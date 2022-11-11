package com.cms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employees")
@Data
@EqualsAndHashCode(callSuper=true)
public class Employee extends Resource{
    private String address;
    private Date dob;
    private String designation;
    private String empId;

}
