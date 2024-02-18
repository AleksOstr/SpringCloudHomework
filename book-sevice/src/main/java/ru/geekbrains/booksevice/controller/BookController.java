package ru.geekbrains.booksevice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.timerstarter.Timer;
import ru.geekbrains.booksevice.model.BookEntity;
import ru.geekbrains.booksevice.request.AuthorRequest;
import ru.geekbrains.booksevice.request.BookRequest;
import ru.geekbrains.booksevice.request.TitleRequest;
import ru.geekbrains.booksevice.service.BookService;

import java.util.List;


@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Timer
    @GetMapping("/all")
    public ResponseEntity<List<BookEntity>> findAll() {
        List<BookEntity> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @Timer
    @GetMapping("/by-title")
    public ResponseEntity<BookEntity> findByTitle(@RequestBody TitleRequest request) {
        BookEntity book = bookService.findByTitle(request);
        return ResponseEntity.ok(book);
    }

    @Timer
    @GetMapping("/by-author")
    public ResponseEntity<List<BookEntity>> findAllByAuthor(@RequestBody AuthorRequest request) {
        List<BookEntity> books = bookService.findAllByAuthor(request);
        return ResponseEntity.ok(books);
    }

    @Timer
    @PostMapping
    public ResponseEntity<BookEntity> save(@RequestBody BookRequest request) {
        BookEntity newBook = bookService.save(request);
        return ResponseEntity.ok(newBook);
    }
}
