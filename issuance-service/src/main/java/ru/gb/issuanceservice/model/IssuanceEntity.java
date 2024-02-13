package ru.gb.issuanceservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "issuances")
public class IssuanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "issuedAt")
    private final LocalDate issuedAt = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "book")
    private BookEntity book;

    @OneToOne
    @JoinColumn(name = "reader")
    private ReaderEntity reader;

    public IssuanceEntity(BookEntity book, ReaderEntity reader) {
        this.book = book;
        this.reader = reader;
    }

    public IssuanceEntity() {
    }
}
