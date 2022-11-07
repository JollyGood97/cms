package com.cms.repository;

import com.cms.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Override
    List<Employee> findAll();
    Optional<Employee> findById(final String id);
}
