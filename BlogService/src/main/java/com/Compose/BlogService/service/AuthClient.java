package com.Compose.BlogService.service;

import com.Compose.BlogService.dto.userDTOS.UserDetailsResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthClient {
    @GetMapping("/user/Internal/profile/{id}")
    UserDetailsResponseDto getUserDetails(@PathVariable Long id);
}
