package ru.gb.readerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.readerservice.model.ReaderEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReaderRepository extends JpaRepository<ReaderEntity, UUID> {
    Optional<ReaderEntity> findFirstByFirstNameAndLastName(String firstName, String lastName);
}
