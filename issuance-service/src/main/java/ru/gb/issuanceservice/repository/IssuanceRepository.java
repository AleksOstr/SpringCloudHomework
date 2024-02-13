package ru.gb.issuanceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.issuanceservice.model.IssuanceEntity;
import ru.gb.issuanceservice.model.ReaderEntity;


import java.util.List;
import java.util.UUID;

@Repository
public interface IssuanceRepository extends JpaRepository<IssuanceEntity, UUID> {
    List<IssuanceEntity> findByReader(ReaderEntity reader);
}
