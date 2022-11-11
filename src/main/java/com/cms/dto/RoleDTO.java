package com.cms.dto;

import com.cms.enums.ERole;
import lombok.Data;

@Data
public class RoleDTO {
    private String id;
    private ERole name;
}
