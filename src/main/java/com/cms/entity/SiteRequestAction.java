package com.cms.entity;

public class SiteRequestAction implements Request {
    SiteRequest siteRequest;

    public SiteRequestAction(SiteRequest siteRequest) {
        this.siteRequest = siteRequest;
    }

    @Override
    public void takeAction() {
        siteRequest.setComplete(true);
    }

    @Override
    public void rejectAction() {
        siteRequest.setComplete(false);
    }
}
