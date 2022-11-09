package com.cms.repository;

import com.cms.entity.MachineryRental;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MachineryRentalRepository extends MongoRepository<MachineryRental, String> {
    List<MachineryRental> findAll();
    Optional<MachineryRental> findById(final String id);
}
