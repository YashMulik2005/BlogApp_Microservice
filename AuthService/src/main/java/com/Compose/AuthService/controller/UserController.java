package com.Compose.AuthService.controller;

import com.Compose.AuthService.dto.SearchRequestDto;
import com.Compose.AuthService.dto.SuccessResponseHandler;
import com.Compose.AuthService.dto.UserDetailsResponseDto;
import com.Compose.AuthService.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> userProfile(@PathVariable Long id){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "User details fetched successfully.", userServiceImpl.userById(id));
    }

    @GetMapping("/Internal/profile/{id}")
    public UserDetailsResponseDto internalUserProfileData(@PathVariable Long id){
         return userServiceImpl.userById(id);
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchUser(@Valid @RequestBody SearchRequestDto searchRequestDto){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "Users fetched successfully.", userServiceImpl.searchUserByEmail(searchRequestDto.getEmail()));
    }
}
