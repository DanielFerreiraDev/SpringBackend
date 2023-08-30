package br.com.springBackend.service;

import br.com.springBackend.model.Person;
import br.com.springBackend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<Person> search() {
        return repository.findAll();
    }

    public Person findById(Integer id) {
        Optional<Person> pessoa = repository.findById(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()).getBody();

    }

    @Transactional
    public Person save(Person person) {
        return repository.save(person);
    }

    public void update(Person person) {
        repository.save(person);
    }

    @Transactional
    public void delete(Integer id) {
        var pessoa = repository.findById(id);
        pessoa.ifPresent(repository::delete);
    }


}
