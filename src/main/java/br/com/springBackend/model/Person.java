package br.com.springBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("nome")
    @Column(name = "nome", nullable = false)
    private String nome;

}
