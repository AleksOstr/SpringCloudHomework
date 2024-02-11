package ru.geekbrains.booksevice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.booksevice.model.AuthorEntity;
import ru.geekbrains.booksevice.model.BookEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    Optional<BookEntity> findFirstByTitle(String title);
    List<BookEntity> findAllByAuthor(AuthorEntity author);
}
