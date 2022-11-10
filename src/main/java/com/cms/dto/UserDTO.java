package com.cms.dto;

import com.cms.entity.Role;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {
    private String id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();
}
