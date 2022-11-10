package com.cms.dto;

import lombok.Data;
import java.util.Date;

@Data
public class LeaveRequestDTO {
    private String id;
    private String employeeId;
    private String description;
    private Date date;
    private boolean approved = false;
    private boolean done = false;
}
