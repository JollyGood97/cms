package com.cms.entity;

public class LeaveRequestAction implements Request{
    LeaveRequest leaveRequest;

    public LeaveRequestAction(LeaveRequest leaveRequest){
        this.leaveRequest = leaveRequest;
    }

    @Override
    public void takeAction() {
        leaveRequest.setApproved(true);
        leaveRequest.setDone(true);
    }

    @Override
    public void rejectAction() {
        leaveRequest.setApproved(false);
        leaveRequest.setDone(true);
    }
}
