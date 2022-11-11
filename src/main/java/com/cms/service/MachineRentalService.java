package com.cms.service;

import com.cms.entity.Machine;
import com.cms.entity.MachineryRental;
import com.cms.repository.MachineRepository;
import com.cms.repository.MachineryRentalRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MachineRentalService {

    private final MachineryRentalRepository machineryRentalRepository;
    private final MachineRepository machineRepository;

    @Autowired
    MachineRentalService(MachineryRentalRepository machineryRentalRepository, MachineRepository machineRepository) {
        this.machineryRentalRepository = machineryRentalRepository;
        this.machineRepository = machineRepository;
    }

    public MachineryRental createMachineryRental(@NonNull final MachineryRental machineryRental) {
        return machineryRentalRepository.save(machineryRental);
    }

    public List<MachineryRental> getMachineryRentals() {
        return machineryRentalRepository.findAll();
    }

    public MachineryRental getMachineryRentalById(String id) {
        return machineryRentalRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Rental Not Found for ID: " + id
        ));
    }

    public void deleteMachineryRental(String id) {
        Optional<MachineryRental> existingRental = machineryRentalRepository.findById(id);
        if (existingRental.isPresent()) {
            List<Machine> machines = machineRepository.findMachineByCompanyId(id);
            if (!machines.isEmpty()) {
                machineRepository.deleteAll(machines);
            }
            machineryRentalRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rental Not Found for ID: " + id);
        }
    }
}
