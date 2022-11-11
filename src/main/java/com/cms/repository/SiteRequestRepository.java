package com.cms.repository;

import com.cms.entity.SiteRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiteRequestRepository extends MongoRepository<SiteRequest, String> {
}
