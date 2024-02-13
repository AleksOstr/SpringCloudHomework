package ru.gb.issuanceservice.sevice;

import org.springframework.stereotype.Service;
import ru.gb.issuanceservice.model.BookEntity;
import ru.gb.issuanceservice.model.IssuanceEntity;
import ru.gb.issuanceservice.model.ReaderEntity;
import ru.gb.issuanceservice.provider.BookProvider;
import ru.gb.issuanceservice.provider.ReaderProvider;
import ru.gb.issuanceservice.repository.IssuanceRepository;
import ru.gb.issuanceservice.request.IssuanceRequest;
import ru.gb.issuanceservice.request.ReaderRequest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class IssuanceService {

    private final IssuanceRepository issuanceRepository;
    private final BookProvider bookProvider;
    private final ReaderProvider readerProvider;

    public IssuanceService(IssuanceRepository issuanceRepository, BookProvider bookProvider, ReaderProvider readerProvider) {
        this.issuanceRepository = issuanceRepository;
        this.bookProvider = bookProvider;
        this.readerProvider = readerProvider;
    }

    public List<IssuanceEntity> findAll() {
        return issuanceRepository.findAll();
    }

    public IssuanceEntity save(IssuanceRequest request) throws NoSuchElementException {
        BookEntity book = getBooks().stream()
                .filter(it -> it.getId().equals(UUID.fromString(request.getBookId())))
                .findFirst()
                .orElseThrow();
        ReaderEntity reader = getReaders().stream()
                .filter(it -> it.getId().equals(UUID.fromString(request.getReaderId())))
                .findFirst()
                .orElseThrow();
        IssuanceEntity issuance = new IssuanceEntity(book, reader);
        issuanceRepository.save(issuance);
        return issuance;
    }

    public List<IssuanceEntity> findByReader(ReaderRequest request) throws NoSuchElementException{
        ReaderEntity reader = getReaders().stream()
                .filter(it -> it.getId().equals(request.getUuid()))
                .findFirst()
                .orElseThrow();
        return issuanceRepository.findByReader(reader);
    }

    private List<BookEntity> getBooks() {
        return bookProvider.getBooks();
    }

    private List<ReaderEntity> getReaders() {
        return readerProvider.getReaders();
    }

}
