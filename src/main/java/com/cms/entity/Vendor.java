package com.cms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Vendor {
    @Id
    private String id;
    private String companyName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

