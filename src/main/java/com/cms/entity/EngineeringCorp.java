package com.cms.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "engineering-corps")
public class EngineeringCorp extends Vendor {
    private String engCorpId;

    public String getEngCorpId() {
        return engCorpId;
    }

    public void setEngCorpId(String engCorpId) {
        this.engCorpId = engCorpId;
    }
}
