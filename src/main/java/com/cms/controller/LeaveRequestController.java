package com.cms.controller;

import com.cms.dto.LeaveRequestDTO;
import com.cms.entity.LeaveRequest;
import com.cms.service.LeaveRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
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
    @PreAuthorize("hasRole('HR_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody LeaveRequestDTO createLeaveRequest(@RequestBody LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = mapper.map(leaveRequestDTO, LeaveRequest.class);
        return mapper.map(leaveRequestService.createLeaveRequest(leaveRequest), LeaveRequestDTO.class);
    }

    @GetMapping
    @PreAuthorize("hasRole('HR_MANAGER') or hasRole('SUPER_ADMIN')")
    public @ResponseBody List<LeaveRequestDTO> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests();
        return leaveRequests.stream().map(req ->
                mapper.map(req, LeaveRequestDTO.class)
        ).collect(Collectors.toList());
    }

    /**
     * Approve or decline leave requests.
     *
     * @param isApproved Boolean
     */
    @PutMapping("/{leaveReqId}/{isApproved}")
    @PreAuthorize("hasRole('HR_MANAGER') or hasRole('SUPER_ADMIN')")
    public void approveOrDecline(@PathVariable String leaveReqId, @PathVariable boolean isApproved) {
        leaveRequestService.approveOrDecline(leaveReqId, isApproved);
    }
}
