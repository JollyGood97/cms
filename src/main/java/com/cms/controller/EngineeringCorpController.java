package com.cms.controller;

import com.cms.dto.EngineeringCorpDTO;
import com.cms.entity.EngineeringCorp;
import com.cms.service.EngineeringCorpService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("engineering-corps")
public class EngineeringCorpController {
    private final EngineeringCorpService engineeringCorpService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    EngineeringCorpController(EngineeringCorpService engineeringCorpService) {
        this.engineeringCorpService = engineeringCorpService;
    }

    @PostMapping
    @PreAuthorize("hasRole('HR_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody EngineeringCorpDTO createEngCorp(@RequestBody EngineeringCorpDTO engineeringCorpDTO) {
        EngineeringCorp engineeringCorp = mapper.map(engineeringCorpDTO, EngineeringCorp.class);
        return mapper.map(engineeringCorpService.createEngCorp(engineeringCorp), EngineeringCorpDTO.class);
    }

    @GetMapping
    @PreAuthorize("hasRole('HR_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody List<EngineeringCorpDTO> getAllEngCorps() {
        List<EngineeringCorp> engCorps = engineeringCorpService.getEngCorps();
        return engCorps.stream().map(corp ->
                mapper.map(corp, EngineeringCorpDTO.class)
        ).collect(Collectors.toList());
    }

    @DeleteMapping("/{corpId}")
    @PreAuthorize("hasRole('HR_MANAGER') or hasRole('SUPER_ADMIN')")
    public void deleteCorp(@PathVariable String corpId) {
        engineeringCorpService.deleteCorp(corpId);
    }
}
