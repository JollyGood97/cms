package com.cms.entity;

public class LeaveRequestAction implements RequestAction {
    LeaveRequest leaveRequest;

    public LeaveRequestAction(LeaveRequest leaveRequest){
        this.leaveRequest = leaveRequest;
    }

    @Override
    public void action() {
        leaveRequest.setApproved(true);
        leaveRequest.setDone(true);
    }

    @Override
    public void reject() {
        leaveRequest.setApproved(false);
        leaveRequest.setDone(true);
    }
}
