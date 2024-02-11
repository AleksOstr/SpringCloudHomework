package ru.geekbrains.booksevice.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.booksevice.model.AuthorEntity;
import ru.geekbrains.booksevice.model.BookEntity;
import ru.geekbrains.booksevice.repository.AuthorRepository;
import ru.geekbrains.booksevice.repository.BookRepository;
import ru.geekbrains.booksevice.request.AuthorRequest;
import ru.geekbrains.booksevice.request.BookRequest;
import ru.geekbrains.booksevice.request.TitleRequest;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookEntity> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookEntity> findAllByAuthor(AuthorRequest request) throws NoSuchElementException{
        AuthorEntity author = authorRepository.findFirstByFirstNameAndLastName(request.getFirstName(), request.getLastName())
                .orElseThrow();
        return bookRepository.findAllByAuthor(author);
    }

    public BookEntity findByTitle(TitleRequest request) throws NoSuchElementException{
        return bookRepository.findFirstByTitle(request.getTitle()).orElseThrow();
    }

    public BookEntity save(BookRequest request) {
        try {
            AuthorEntity author = authorRepository.findFirstByFirstNameAndLastName(request.getAuthorFirstName(), request.getAuthorLastName())
                    .orElseThrow();
            BookEntity book = new BookEntity(request.getTitle(), author);
            author.getBooks().add(book);
            authorRepository.save(author);
            bookRepository.save(book);
            return book;
        } catch (NoSuchElementException e) {
            AuthorEntity author = new AuthorEntity(request.getAuthorFirstName(), request.getAuthorLastName());
            BookEntity book = new BookEntity(request.getTitle(), author);
            author.getBooks().add(book);
            authorRepository.save(author);
            bookRepository.save(book);
            return book;
        }
    }
}
