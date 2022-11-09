package com.cms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper=true)
public class EmployeeDTO extends ResourceDTO{
    private String address;
    private Date dob;
    private String designation;
    private String empId;
    public EmployeeDTO() {
    }
}
