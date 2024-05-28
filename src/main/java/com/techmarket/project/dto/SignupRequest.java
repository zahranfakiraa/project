package com.techmarket.project.dto;

import lombok.Data;

@Data
public class SignupRequest {
    
    private String email;

    private String password;

    private String name;
}
