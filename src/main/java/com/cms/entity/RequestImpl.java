package com.cms.entity;


public class RequestImpl implements Request {
    RequestAction requestAction;

    public RequestImpl(RequestAction requestAction) {
        this.requestAction = requestAction;
    }

    public void takeAction() {
        requestAction.action();
    }

    public void rejectAction(){
        requestAction.reject();
    }

}
