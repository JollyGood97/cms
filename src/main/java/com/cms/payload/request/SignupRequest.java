package com.cms.payload.request;

import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
public class SignupRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
    private Set<String> roles;
}
