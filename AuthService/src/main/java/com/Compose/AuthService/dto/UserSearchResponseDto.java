package com.Compose.AuthService.dto;

public class UserSearchResponseDto {
    private Long id;
    private String email;
    private String profile_img;

    public UserSearchResponseDto() {
    }

    public UserSearchResponseDto(Long id, String email, String profile_img) {
        this.id = id;
        this.email = email;
        profile_img = profile_img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        profile_img = profile_img;
    }
}
