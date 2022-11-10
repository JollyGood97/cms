package com.cms.dto;

import com.cms.enums.ResourceType;
import lombok.Data;

@Data
public class ResourceDTO {
    private String id;
    private String allocatedSiteId;
    private String name;
    private ResourceType type;
    private String companyId;

}
