package com.cms.dto;

public class MachineDTO extends ResourceDTO{
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
