package ru.geekbrains.booksevice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.print.Book;
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
    private List<BookEntity> books;

    public AuthorEntity() {
    }

    public AuthorEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
