package com.techmarket.project.services.auth;

import com.techmarket.project.dto.SignupRequest;
import com.techmarket.project.dto.UserDTO;

public interface AuthService {

    UserDTO createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
