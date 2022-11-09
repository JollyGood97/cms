package com.cms.entity;

import com.cms.enums.SiteRequestType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "leave-requests")
@Data
public class LeaveRequest {
    @Id
    private String id;
    private String employeeId;
    private String description;
    private Date date;
    private boolean approved = false;
}
