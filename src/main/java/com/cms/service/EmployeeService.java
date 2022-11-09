package com.cms.service;

import com.cms.controller.EmployeeController;
import com.cms.entity.Employee;
import com.cms.repository.EmployeeRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(@NonNull final Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Employee Not Found for ID: " + id
        ));
    }

    public Employee updateEmployee(String id, Employee currentEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            return employeeRepository.save(currentEmployee);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found for ID: " + id);
        }
    }

    public void deleteEmployee(String id){
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found for ID: " + id);
        }
    }

    public List<Employee> getEmployeesByCompany(String compId){
        return employeeRepository.findEmployeesByCompanyId(compId);
    }
}
