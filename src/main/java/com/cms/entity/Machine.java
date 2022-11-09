package com.cms.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "machines")
public class Machine extends Resource{
    private String machineId;
    private String category;

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
