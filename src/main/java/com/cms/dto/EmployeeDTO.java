package com.cms.dto;

import com.cms.enums.ResourceType;

import java.util.Date;


public class EmployeeDTO extends ResourceDTO{
    private String address;
    private Date dob;
    private String designation;

    public EmployeeDTO() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
