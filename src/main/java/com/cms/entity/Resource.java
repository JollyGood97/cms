package com.cms.entity;


import com.cms.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
public class Resource {
    @Id
    private String id;
    private String allocatedSiteId;
    private String name;
    private ResourceType type;
    private String companyId;

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
