package com.cms.service;

import com.cms.entity.*;
import com.cms.repository.LeaveRequestRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    @Autowired
    LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public LeaveRequest createLeaveRequest(@NonNull final LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest getLeaveReqById(String id) {
        return leaveRequestRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Leave request not found for ID: " + id
        ));
    }

    /**
     * Approve or decline leave requests.
     * Uses Bridge Pattern
     * @param approve Boolean
     */
    public void approveOrDecline(@NonNull String id, boolean approve) {
        LeaveRequest leaveRequest = getLeaveReqById(id);
        RequestAction leaveReq = new LeaveRequestAction(leaveRequest);
        if (approve) {
            new RequestImpl(leaveReq).takeAction();
        } else {
            new RequestImpl(leaveReq).rejectAction();
        }
        leaveRequestRepository.save(leaveRequest);
    }
}
