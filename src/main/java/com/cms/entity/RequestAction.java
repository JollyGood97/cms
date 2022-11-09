package com.cms.entity;


public class RequestAction {
    Request request;

    public RequestAction(Request request) {
        this.request = request;
    }

    public void action() {
        request.takeAction();
    }

    public void reject(){
        request.rejectAction();
    }

}
