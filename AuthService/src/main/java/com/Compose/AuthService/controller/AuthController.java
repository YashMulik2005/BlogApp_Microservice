package com.Compose.AuthService.controller;

import com.Compose.AuthService.dto.LoginRequestDto;
import com.Compose.AuthService.dto.SignupRequestDto;
import com.Compose.AuthService.dto.SuccessResponseHandler;
import com.Compose.AuthService.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController{

    @Autowired
    private AuthService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequestDto signupRequestDto){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.CREATED, true,
                "User created successfully.", userService.Signup(signupRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "User Logged in successfully.", userService.Login(loginRequestDto));
    }
}
