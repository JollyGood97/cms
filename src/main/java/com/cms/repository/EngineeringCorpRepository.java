package com.cms.repository;

import com.cms.entity.EngineeringCorp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EngineeringCorpRepository extends MongoRepository<EngineeringCorp, String> {
}
