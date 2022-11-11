package com.cms.repository;

import com.cms.entity.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MachineRepository extends MongoRepository<Machine, String> {
    List<Machine> findMachineByCompanyId(final String compId);
}
