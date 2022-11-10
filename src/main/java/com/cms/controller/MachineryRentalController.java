package com.cms.controller;

import com.cms.dto.EngineeringCorpDTO;
import com.cms.dto.MachineryRentalDTO;
import com.cms.entity.EngineeringCorp;
import com.cms.entity.MachineryRental;
import com.cms.service.MachineRentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("machinery-rentals")
public class MachineryRentalController {

    private final MachineRentalService machineRentalService;

    @Autowired
    private ModelMapper mapper;

    MachineryRentalController(MachineRentalService machineRentalService) {
        this.machineRentalService = machineRentalService;
    }

    @PostMapping
    public @ResponseBody MachineryRentalDTO createMachineryRental(@RequestBody MachineryRentalDTO machineryRentalDTO) {
        MachineryRental machineryRental = mapper.map(machineryRentalDTO, MachineryRental.class);
        return mapper.map(machineRentalService.createMachineryRental(machineryRental), MachineryRentalDTO.class);
    }

    @GetMapping
    public @ResponseBody List<MachineryRentalDTO> getAllMachineryRentals() {
        List<MachineryRental> machineryRentals = machineRentalService.getMachineryRentals();
        return machineryRentals.stream().map(machineryRental ->
                mapper.map(machineryRental, MachineryRentalDTO.class)
        ).collect(Collectors.toList());
    }

    @DeleteMapping("/{rentalId}")
    public void deleteMachineryRental(@PathVariable String rentalId) {
        machineRentalService.deleteMachineryRental(rentalId);
    }
}
