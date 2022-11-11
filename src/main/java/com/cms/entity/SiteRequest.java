package com.cms.entity;

import com.cms.enums.SiteRequestType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "site-requests")
@Data
public class SiteRequest{
    @Id
    private String id;
    private String siteId;
    private String description;
    private Date date;
    private boolean complete = false;
    private SiteRequestType siteRequestType;
}
