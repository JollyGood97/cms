package com.cms.service;

import com.cms.entity.*;
import com.cms.repository.SiteRequestRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SiteRequestService {

    private final SiteRequestRepository siteRequestRepository;

    @Autowired
    SiteRequestService(SiteRequestRepository siteRequestRepository) {
        this.siteRequestRepository = siteRequestRepository;
    }

    public SiteRequest createSiteRequest(@NonNull final SiteRequest siteRequest) {
        return siteRequestRepository.save(siteRequest);
    }

    public List<SiteRequest> getAllSiteRequests() {
        return siteRequestRepository.findAll();
    }

    public SiteRequest getSiteReqById(String id) {
        return siteRequestRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Site request not found for ID: " + id
        ));
    }

    public void markCompleteOrUndo(@NonNull String id, boolean isComplete) {
        SiteRequest siteRequest = getSiteReqById(id);
        RequestAction siteReq = new SiteRequestAction(siteRequest);
        if (isComplete) {
            new RequestImpl(siteReq).takeAction();
        } else {
            new RequestImpl(siteReq).rejectAction();
        }
        siteRequestRepository.save(siteRequest);
    }
}
