package ru.gb.readerservice.service;

import org.springframework.stereotype.Service;
import ru.gb.readerservice.model.ReaderEntity;
import ru.gb.readerservice.repository.ReaderRepository;
import ru.gb.readerservice.request.ReaderRequest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public List<ReaderEntity> findAll() {
        return readerRepository.findAll();
    }

    public ReaderEntity findByName(ReaderRequest request) throws NoSuchElementException {
        return readerRepository.findFirstByFirstNameAndLastName(request.getFirstName(), request.getLastName()).orElseThrow();
    }

    public ReaderEntity save(ReaderRequest request) {
        ReaderEntity newReader = new ReaderEntity(request.getFirstName(), request.getLastName());
        readerRepository.save(newReader);
        return newReader;
    }
}
