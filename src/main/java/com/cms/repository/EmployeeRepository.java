package com.cms.repository;

import com.cms.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findEmployeesByCompanyId(final String compId);
}
