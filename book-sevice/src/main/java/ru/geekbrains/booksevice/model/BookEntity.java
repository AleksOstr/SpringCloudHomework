package ru.geekbrains.booksevice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    @ManyToOne
    private AuthorEntity author;

    public BookEntity(String title, AuthorEntity author) {
        this.title = title;
        this.author = author;
    }

    public BookEntity() {
    }
}
