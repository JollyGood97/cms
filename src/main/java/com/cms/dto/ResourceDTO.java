package com.cms.dto;

import com.cms.enums.ResourceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResourceDTO {
    private String id;
    private String allocatedSiteId;
    private String name;
    private ResourceType type;
    private String companyId;

    public ResourceDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAllocatedSiteId() {
        return allocatedSiteId;
    }

    public void setAllocatedSiteId(String allocatedSiteId) {
        this.allocatedSiteId = allocatedSiteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
