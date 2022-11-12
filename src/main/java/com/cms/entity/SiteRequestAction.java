package com.cms.entity;

public class SiteRequestAction implements RequestAction {
    SiteRequest siteRequest;

    public SiteRequestAction(SiteRequest siteRequest) {
        this.siteRequest = siteRequest;
    }

    @Override
    public void action() {
        siteRequest.setComplete(true);
    }

    @Override
    public void reject() {
        siteRequest.setComplete(false);
    }
}
