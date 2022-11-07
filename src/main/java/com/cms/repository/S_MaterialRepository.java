package com.cms.repository;

import com.cms.entity.S_MaterialModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface S_MaterialRepository extends MongoRepository<S_MaterialModel, String> {

}

