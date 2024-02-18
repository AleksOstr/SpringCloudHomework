package ru.gb.issuanceservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.issuanceservice.model.IssuanceEntity;
import ru.gb.issuanceservice.request.IssuanceRequest;
import ru.gb.issuanceservice.request.ReaderRequest;
import ru.gb.issuanceservice.sevice.IssuanceService;
import ru.gb.timerstarter.Timer;

import java.util.List;

@RestController
@RequestMapping("/api/issuance")
public class IssuanceController {

    private IssuanceService issuanceService;

    public IssuanceController(IssuanceService issuanceService) {
        this.issuanceService = issuanceService;
    }

    @Timer
    @GetMapping("/all")
    public ResponseEntity<List<IssuanceEntity>> findAll() {
        List<IssuanceEntity> issuances = issuanceService.findAll();
        return ResponseEntity.ok(issuances);
    }

    @Timer
    @GetMapping("/by-reader")
    public ResponseEntity<List<IssuanceEntity>> findByReader(@RequestBody ReaderRequest request) {
        List<IssuanceEntity> issuances = issuanceService.findByReader(request);
        return ResponseEntity.ok(issuances);
    }

    @Timer
    @PostMapping("/new")
    public ResponseEntity<IssuanceEntity> save(@RequestBody IssuanceRequest request) {
        IssuanceEntity issuance = issuanceService.save(request);
        return ResponseEntity.ok(issuance);
    }
}
