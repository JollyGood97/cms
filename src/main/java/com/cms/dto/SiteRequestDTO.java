package com.cms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SiteRequestDTO {
    private String id;
    private String siteId;
    private String description;
    private Date date;
    private boolean complete = false;
}
