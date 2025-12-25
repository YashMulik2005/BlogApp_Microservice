package com.Compose.BlogService.service;

import com.Compose.BlogService.dto.commentDTOS.CommentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8083" , value = "BLOG-SERVICE")
public interface CommentClient {

    @GetMapping("/comment/internal/{id}")
    List<CommentResponseDto> getCommentByBlogId(@PathVariable Long id);
}
