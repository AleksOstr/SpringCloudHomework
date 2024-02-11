package ru.gb.issuanceservice.model;

import jakarta.persistence.*;
import ru.gb.readerservice.model.ReaderEntity;
import ru.geekbrains.booksevice.model.BookEntity;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "issuances")
public class IssuanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "issuedAt")
    private LocalDate issuedAt;

    @OneToOne
    private BookEntity book;

    @OneToOne
    private ReaderEntity reader;
}
