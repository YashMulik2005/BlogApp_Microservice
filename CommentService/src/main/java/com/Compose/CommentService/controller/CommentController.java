package com.Compose.CommentService.controller;

import com.Compose.CommentService.dto.CommentRequestDto;
import com.Compose.CommentService.dto.CommentResponseDto;
import com.Compose.CommentService.dto.SuccessResponseHandler;
import com.Compose.CommentService.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestBody CommentRequestDto commentRequestDto){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "Comment added successfully.", commentServiceImpl.addComment(commentRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetCommentByPost(@PathVariable Long id){
        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
                "Comment fetched successfully.", commentServiceImpl.commentByPostId(id));
    }

    @GetMapping("/internal/{id}")
    public List<CommentResponseDto> GetCommentByPostInternal(@PathVariable Long id){
        return commentServiceImpl.commentByPostId(id);
//        return SuccessResponseHandler.successResponseBuilder(HttpStatus.OK, true,
//                "Comment fetched successfully.", commentServiceImpl.commentByPostId(id));
    }

}
