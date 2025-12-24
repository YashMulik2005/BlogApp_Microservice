package com.Compose.AuthService.dto;

public class UserDetailsResponseDto {
    private Long id;
    private String email;
    private String fName;
    private String lName;
    private String Profile_img;

    public UserDetailsResponseDto() {
    }

    public UserDetailsResponseDto(Long id, String email, String fName, String lName, String password, String profile_img) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.Profile_img = profile_img;
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getProfile_img() {
        return Profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.Profile_img = profile_img;
    }
}
