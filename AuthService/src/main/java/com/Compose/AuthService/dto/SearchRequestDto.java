package com.Compose.AuthService.dto;

import jakarta.validation.constraints.NotBlank;

public class SearchRequestDto {
    @NotBlank(message = "search text is required.")
    private String email;

    public SearchRequestDto() {
    }

    public SearchRequestDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
