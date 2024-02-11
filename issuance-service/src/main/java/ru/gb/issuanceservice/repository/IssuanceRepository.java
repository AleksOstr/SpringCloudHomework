package ru.gb.issuanceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.issuanceservice.model.IssuanceEntity;

import java.util.UUID;

@Repository
public interface IssuanceRepository extends JpaRepository<IssuanceEntity, UUID> {
}
