package com.cms.controller;

import com.cms.dto.LeaveRequestDTO;
import com.cms.entity.LeaveRequest;
import com.cms.service.LeaveRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("leave-requests")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public @ResponseBody LeaveRequestDTO createLeaveRequest(@RequestBody LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = mapper.map(leaveRequestDTO, LeaveRequest.class);
        return mapper.map(leaveRequestService.createLeaveRequest(leaveRequest), LeaveRequestDTO.class);
    }

    @GetMapping
    public @ResponseBody List<LeaveRequestDTO> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests();
        return leaveRequests.stream().map(req ->
                mapper.map(req, LeaveRequestDTO.class)
        ).collect(Collectors.toList());
    }

    @PutMapping("/{leaveReqId}/{isApproved}")
    public void approveOrDecline(@PathVariable String leaveReqId, @PathVariable boolean isApproved) {
        leaveRequestService.approveOrDecline(leaveReqId, isApproved);
    }
}
