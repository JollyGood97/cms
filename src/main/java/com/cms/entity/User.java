package com.cms.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Data
public class User {
    private String id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();
}
