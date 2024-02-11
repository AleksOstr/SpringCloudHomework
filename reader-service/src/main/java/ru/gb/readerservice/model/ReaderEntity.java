package ru.gb.readerservice.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.geekbrains.booksevice.model.BookEntity;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "readers")
public class ReaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lasstName")
    private String lastName;

}
