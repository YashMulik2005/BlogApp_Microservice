package com.Compose.BlogService.dto;

import com.Compose.BlogService.dto.userDTOS.UserDetailsResponseDto;

import java.time.LocalDateTime;

public class SingleBlogDetaliedDto {
    private Long id;
    private String title;
    private String content;
    private boolean isDraft;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDetailsResponseDto user;

    public SingleBlogDetaliedDto() {
    }

    public SingleBlogDetaliedDto(Long id, String title, String content, boolean isDraft, LocalDateTime createdAt, LocalDateTime updatedAt, UserDetailsResponseDto user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isDraft = isDraft;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public UserDetailsResponseDto getUser() {
        return user;
    }

    public void setUser(UserDetailsResponseDto user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "SingleBlogDetaliedDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isDraft=" + isDraft +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", user=" + user +
                '}';
    }
}
