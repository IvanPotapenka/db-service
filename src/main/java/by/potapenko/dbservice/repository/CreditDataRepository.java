package by.potapenko.dbservice.repository;

import by.potapenko.dbservice.model.entity.OfferDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreditDataRepository extends MongoRepository<OfferDataEntity, UUID> {
}