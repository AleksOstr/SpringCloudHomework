package ru.geekbrains.booksevice.request;

import lombok.Data;

@Data
public class BookRequest {

    private final String title;
    private final String authorFirstName;
    private final String authorLastName;
}
