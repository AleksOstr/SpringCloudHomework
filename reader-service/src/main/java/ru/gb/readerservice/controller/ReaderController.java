package ru.gb.readerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.readerservice.model.ReaderEntity;
import ru.gb.readerservice.request.ReaderRequest;
import ru.gb.readerservice.service.ReaderService;

import java.util.List;

@RestController
@RequestMapping("/api/reader")
public class ReaderController {

    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReaderEntity>> findAll() {
        List<ReaderEntity> readers = readerService.findAll();
        return ResponseEntity.ok(readers);
    }

    @GetMapping("/by-name")
    public ResponseEntity<ReaderEntity> findByName(@RequestBody ReaderRequest request) {
        ReaderEntity reader = readerService.findByName(request);
        return ResponseEntity.ok(reader);
    }

    @PostMapping
    public ResponseEntity<ReaderEntity> save(@RequestBody ReaderRequest request) {
        ReaderEntity reader = readerService.save(request);
        return ResponseEntity.ok(reader);
    }
}
