package com.Compose.AuthService.dto;

public class UserSearchResponseDto {
    private Long id;
    private String email;
    private String Profile_img;

    public UserSearchResponseDto() {
    }

    public UserSearchResponseDto(Long id, String email, String profile_img) {
        this.id = id;
        this.email = email;
        Profile_img = profile_img;
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
        return Profile_img;
    }

    public void setProfile_img(String profile_img) {
        Profile_img = profile_img;
    }
}
