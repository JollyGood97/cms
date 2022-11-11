package com.cms.controller;

import com.cms.dto.MachineDTO;
import com.cms.entity.Machine;
import com.cms.service.MachineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("machines")
public class MachineController {

    private final MachineService machineService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @PostMapping
    public @ResponseBody MachineDTO createMachine(@RequestBody MachineDTO machineDTO) {
        Machine machine = mapper.map(machineDTO, Machine.class);
        return mapper.map(machineService.createMachine(machine), MachineDTO.class);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_MACHINE_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody List<MachineDTO> getAllMachines() {
        List<Machine> machines = machineService.getMachines();
        return machines.stream().map(machine ->
                mapper.map(machine, MachineDTO.class)
        ).collect(Collectors.toList());
    }

    @GetMapping("/{machineId}")
    @PreAuthorize("hasRole('ROLE_MACHINE_MANAGER') or hasRole('SUPER_ADMIN')")

    public @ResponseBody MachineDTO getMachineById(@PathVariable String machineId) {
        return mapper.map(machineService.getMachineById(machineId), MachineDTO.class);
    }

    @PutMapping("/{machineId}")
    @PreAuthorize("hasRole('ROLE_MACHINE_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody MachineDTO updateMachine(@RequestBody MachineDTO machineDTO, @PathVariable String machineId) {
        Machine machine = mapper.map(machineDTO, Machine.class);
        return mapper.map(machineService.updateMachine(machineId, machine), MachineDTO.class);

    }

    @DeleteMapping("/{machineId}")
    @PreAuthorize("hasRole('ROLE_MACHINE_MANAGER') or hasRole('SUPER_ADMIN')")
    public void deleteMachine(@PathVariable String machineId) {
        machineService.deleteMachine(machineId);
    }

    /**
     * Get machines attached to machinery rental.
     *
     * @param rentalId The id of the machinery rental
     * @return MachineDTO List of returned
     */
    @GetMapping("/rentals/{rentalId}")
    @PreAuthorize("hasRole('ROLE_MACHINE_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody List<MachineDTO> getMachinesByCompany(@PathVariable String rentalId) {
        List<Machine> machines = machineService.getMachinesByCompany(rentalId);
        return machines.stream().map(machine ->
                mapper.map(machine, MachineDTO.class)
        ).collect(Collectors.toList());
    }

}
