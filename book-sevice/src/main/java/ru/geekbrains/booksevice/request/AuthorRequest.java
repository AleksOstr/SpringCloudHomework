package ru.geekbrains.booksevice.request;

import lombok.Data;

@Data
public class AuthorRequest {

    private String firstName;
    private String lastName;
}
