package ru.gb.issuanceservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")
    private List<BookEntity> books;

    public AuthorEntity() {
    }

    public AuthorEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = new ArrayList<>();
    }
}
