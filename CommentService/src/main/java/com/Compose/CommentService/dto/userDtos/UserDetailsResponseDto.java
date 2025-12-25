package com.Compose.CommentService.dto.userDtos;

public class UserDetailsResponseDto {
    private Long id;
    private String fName;
    private String lName;
    private String profile_img;

    public UserDetailsResponseDto() {
    }

    public UserDetailsResponseDto(Long id, String fName, String lName, String password, String profile_img) {
        this.id = id;
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


    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
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
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", profile_img='" + profile_img + '\'' +
                '}';
    }
}
