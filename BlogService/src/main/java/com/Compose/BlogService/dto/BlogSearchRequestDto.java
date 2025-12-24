package com.Compose.BlogService.dto;

import jakarta.validation.constraints.NotBlank;

public class BlogSearchRequestDto {
    @NotBlank(message = "Title is required.")
    private String title;

    public BlogSearchRequestDto() {
    }

    public BlogSearchRequestDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
