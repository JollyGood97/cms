package com.cms.entity;


import com.cms.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Resource {
    @Id
    private String id;
    private String allocatedSiteId;
    private String name;
    private ResourceType type;
    private String companyId;
}
