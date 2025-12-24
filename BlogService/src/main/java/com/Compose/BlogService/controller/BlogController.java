package com.Compose.BlogService.controller;

import com.Compose.BlogService.dto.BlogRequestDto;
import com.Compose.BlogService.dto.BlogSearchRequestDto;
import com.Compose.BlogService.dto.SuccessResponseHandler;
import com.Compose.BlogService.service.impl.BlogServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<?> addBlog(@Valid @RequestBody BlogRequestDto blogRequestDto){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "Blog added successfully.", blogServiceImpl.addBlog(blogRequestDto));
    }

    @GetMapping
    public ResponseEntity<?> getBlogs(){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "Blogs fetched successfully.", blogServiceImpl.getBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Long id){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "Blogs fetched successfully.", blogServiceImpl.getSingleBlog(id));
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchBlog(@RequestBody BlogSearchRequestDto blogSearchRequestDto){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "Blog searched successfully.", blogServiceImpl.searchBlog(blogSearchRequestDto.getTitle()));
    }

}
