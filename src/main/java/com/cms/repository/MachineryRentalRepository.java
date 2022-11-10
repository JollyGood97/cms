package com.cms.repository;

import com.cms.entity.MachineryRental;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MachineryRentalRepository extends MongoRepository<MachineryRental, String> {
}
