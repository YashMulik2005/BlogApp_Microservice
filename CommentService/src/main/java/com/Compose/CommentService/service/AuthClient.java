package com.Compose.CommentService.service;

import com.Compose.CommentService.dto.userDtos.UserDetailsResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081" , value = "AUTH-SERVICE")
public interface AuthClient {
    @GetMapping("/user/Internal/profile/{id}")
    UserDetailsResponseDto getUserDetails(@PathVariable Long id);
}
