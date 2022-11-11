package com.cms.service;

import com.cms.entity.Employee;
import com.cms.entity.EngineeringCorp;
import com.cms.repository.EmployeeRepository;
import com.cms.repository.EngineeringCorpRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EngineeringCorpService {

    private final EngineeringCorpRepository engineeringCorpRepository;
    private final EmployeeRepository employeeRepository;


    @Autowired
    EngineeringCorpService(EngineeringCorpRepository engineeringCorpRepository, EmployeeRepository employeeRepository){
        this.engineeringCorpRepository = engineeringCorpRepository;
        this.employeeRepository = employeeRepository;
    }

    public EngineeringCorp createEngCorp(@NonNull final EngineeringCorp engineeringCorp) {
        return engineeringCorpRepository.save(engineeringCorp);
    }

    public List<EngineeringCorp> getEngCorps(){
        return engineeringCorpRepository.findAll();
    }

    public EngineeringCorp getCorpById(String id) {
        return engineeringCorpRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Corp Not Found for ID: " + id
        ));
    }

    /**
     * Deletes an Engineering Corporation
     * Also deletes any employees attached to the engineering cooperation
     * @param id String id of engineering cooperation to be deleted
     */
    public void deleteCorp(String id){
        Optional<EngineeringCorp> existingCorp = engineeringCorpRepository.findById(id);
        if (existingCorp.isPresent()) {
            List<Employee> employees = employeeRepository.findEmployeesByCompanyId(id);
            if(!employees.isEmpty()){
                employeeRepository.deleteAll(employees);
            }
            engineeringCorpRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Corp Not Found for ID: " + id);
        }
    }
}
