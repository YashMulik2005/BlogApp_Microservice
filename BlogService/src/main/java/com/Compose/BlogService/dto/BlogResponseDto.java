package com.Compose.BlogService.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

public class BlogResponseDto {
    private Long id;
    private String title;
    private String content;
    private boolean isDraft;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BlogResponseDto() {
    }

    public BlogResponseDto(Long id, String title, String content, boolean isDraft, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId, String email, String fname, String lname) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isDraft = isDraft;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
//        this.userId = userId;
//        this.email = email;
//        this.fname = fname;
//        this.lname = lname;
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

}
