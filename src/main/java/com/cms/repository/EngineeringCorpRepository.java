package com.cms.repository;

import com.cms.entity.EngineeringCorp;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EngineeringCorpRepository extends MongoRepository<EngineeringCorp, String> {
    Optional<EngineeringCorp> findById(final String id);
}
