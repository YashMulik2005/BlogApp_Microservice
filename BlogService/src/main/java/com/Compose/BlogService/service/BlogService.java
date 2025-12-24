package com.Compose.BlogService.service;

import com.Compose.BlogService.dto.BlogRequestDto;
import com.Compose.BlogService.dto.BlogResponseDto;
import com.Compose.BlogService.dto.BlogSearchResponseDto;
import com.Compose.BlogService.dto.SingleBlogDetaliedDto;

import java.util.List;

public interface BlogService {
    BlogResponseDto addBlog(BlogRequestDto blogRequestDto);
    List<BlogResponseDto> getBlogs();
    SingleBlogDetaliedDto getSingleBlog(Long id);
    BlogResponseDto updateBlog(Long id, BlogRequestDto blogRequestDto);
    void deleteBlog(Long id);
    List<BlogSearchResponseDto> searchBlog(String title);
}
