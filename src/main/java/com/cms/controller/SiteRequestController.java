package com.cms.controller;

import com.cms.dto.EmployeeDTO;
import com.cms.dto.EngineeringCorpDTO;
import com.cms.dto.SiteRequestDTO;
import com.cms.entity.EngineeringCorp;
import com.cms.entity.SiteRequest;
import com.cms.service.SiteRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("site-requests")
public class SiteRequestController {

    private final SiteRequestService siteRequestService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    SiteRequestController(SiteRequestService siteRequestService) {
        this.siteRequestService = siteRequestService;
    }

    @PostMapping
    public @ResponseBody SiteRequestDTO createSiteRequest(@RequestBody SiteRequestDTO siteRequestDTO) {
        SiteRequest siteRequest = mapper.map(siteRequestDTO, SiteRequest.class);
        return mapper.map(siteRequestService.createSiteRequest(siteRequest), SiteRequestDTO.class);
    }

    @GetMapping
    public @ResponseBody List<SiteRequestDTO> getAllSiteRequests() {
        List<SiteRequest> siteRequests = siteRequestService.getAllSiteRequests();
        return siteRequests.stream().map(req ->
                mapper.map(req, SiteRequestDTO.class)
        ).collect(Collectors.toList());
    }

    @PutMapping("/{siteReqId}/{isComplete}")
    public void markComplete(@PathVariable String siteReqId, @PathVariable boolean isComplete) {
        siteRequestService.markCompleteOrUndo(siteReqId, isComplete);
    }
}
