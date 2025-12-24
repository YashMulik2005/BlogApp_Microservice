package com.Compose.BlogService.dto.userDTOS;

public class UserDetailsResponseDto {
    private Long id;
    private String email;
    private String fName;
    private String lName;
    private String profile_img;

    public UserDetailsResponseDto() {
    }

    public UserDetailsResponseDto(Long id, String email, String fName, String lName, String password, String profile_img) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.profile_img = profile_img;
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
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    @Override
    public String toString() {
        return "UserDetailsResponseDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", profile_img='" + profile_img + '\'' +
                '}';
    }
}
