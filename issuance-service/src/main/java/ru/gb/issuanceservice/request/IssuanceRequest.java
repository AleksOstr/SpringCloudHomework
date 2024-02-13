package ru.gb.issuanceservice.request;

import lombok.Data;

import java.util.UUID;

@Data
public class IssuanceRequest {
    private String bookId;
    private String readerId;
}
