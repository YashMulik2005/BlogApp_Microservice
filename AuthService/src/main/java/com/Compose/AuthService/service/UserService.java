package com.Compose.AuthService.service;

import com.Compose.AuthService.dto.UserDetailsResponseDto;
import com.Compose.AuthService.dto.UserSearchResponseDto;

import java.util.List;

public interface UserService {
    UserDetailsResponseDto userById(Long id);
    List<UserSearchResponseDto> searchUserByEmail(String email);
}
