package com.cms.dto;

import com.cms.enums.SiteRequestType;
import lombok.Data;

import java.util.Date;

@Data
public class SiteRequestDTO {
    private String id;
    private String siteId;
    private String description;
    private Date date;
    private boolean complete = false;
    private SiteRequestType siteRequestType;
}
