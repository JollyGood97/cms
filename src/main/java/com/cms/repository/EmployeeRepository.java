package com.cms.repository;

import com.cms.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findById(final String id);
    List<Employee> findEmployeesByCompanyId(final String compId);
}
