package com.techmarket.project.dto;

import com.techmarket.project.enums.UserRole;

import lombok.Data;

@Data
public class UserDTO {
    
    private Long id;

    private String email;

    private String name;

    private UserRole userRole;
}
