package com.cms.repository;

import com.cms.entity.MachinerySupplier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MachinerySupplierRepository extends MongoRepository<MachinerySupplier, String> {
    List<MachinerySupplier> findAll();
    Optional<MachinerySupplier> findById(final String id);
}
