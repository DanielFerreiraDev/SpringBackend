package br.com.springBackend.api;

import br.com.springBackend.model.Person;
import br.com.springBackend.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "pessoas")
public class PersonController {

    private final PersonService service;

    @GetMapping
    public List<Person> search() {
        return service.search();
    }

    @GetMapping("/{id}")
    public Person getPessoaById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Person save(@RequestBody Person person) {
        return service.save(person);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Person person) throws Exception {
        if (!id.equals(person.getId())) {
            throw new Exception("Não é possível alterar essa pessoa. As informações enviadas são de uma pessoa diferente.");
        }
        service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
