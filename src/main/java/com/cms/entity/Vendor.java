package com.cms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Vendor {
    @Id
    private String id;
    private String companyName;
}

