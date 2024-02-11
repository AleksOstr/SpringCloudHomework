package ru.geekbrains.booksevice.request;

import lombok.Data;

@Data
public class AuthorRequest {

    private final String firstName;
    private final String lastName;
}
