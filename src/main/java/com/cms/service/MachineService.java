package com.cms.service;

import com.cms.entity.Employee;
import com.cms.entity.Machine;
import com.cms.repository.MachineRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {
    private final MachineRepository machineRepository;

    @Autowired
    MachineService(MachineRepository machineRepository){
        this.machineRepository = machineRepository;
    }

    public Machine createMachine(@NonNull final Machine machine) {
        return machineRepository.save(machine);
    }

    public List<Machine> getMachines() {
        return machineRepository.findAll();
    }

    public Machine getMachineById(String id) {
        return machineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Machine Not Found for ID: " + id
        ));
    }

    public Machine updateMachine(String id, Machine currentMachine) {
        Optional<Machine> existingMachine = machineRepository.findById(id);
        if (existingMachine.isPresent()) {
            return machineRepository.save(currentMachine);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Machine Not Found for ID: " + id);
        }
    }

    public void deleteMachine(String id){
        Optional<Machine> existingMachine = machineRepository.findById(id);
        if (existingMachine.isPresent()) {
            machineRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Machine Not Found for ID: " + id);
        }
    }

    public List<Machine> getMachinesByCompany(String compId){
        return machineRepository.findMachineByCompanyId(compId);
    }
}
