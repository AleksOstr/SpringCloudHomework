package ru.geekbrains.booksevice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne
    @JoinColumn(name = "author")
    @JsonIgnoreProperties("books")
    private AuthorEntity author;

    public BookEntity(String title, AuthorEntity author) {
        this.title = title;
        this.author = author;
    }

    public BookEntity() {
    }
}
