package com.cms.repository;

import com.cms.entity.LeaveRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeaveRequestRepository extends MongoRepository<LeaveRequest, String> {
}
