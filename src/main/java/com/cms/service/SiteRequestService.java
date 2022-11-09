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
    SiteRequestService(SiteRequestRepository siteRequestRepository){
        this.siteRequestRepository = siteRequestRepository;
    }

    public SiteRequest createSiteRequest(@NonNull final SiteRequest siteRequest){
        return siteRequestRepository.save(siteRequest);
    }

    public List<SiteRequest> getAllSiteRequests(){
        return siteRequestRepository.findAll();
    }

    public SiteRequest getSiteReqById(String id) {
        return siteRequestRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Site request not found for ID: " + id
        ));
    }

    public void markComplete(@NonNull String id){
        SiteRequest siteRequest = getSiteReqById(id);
        Request siteReq = new SiteRequestAction(siteRequest);
        new RequestAction(siteReq).action();
        siteRequestRepository.save(siteRequest);
    }
}
