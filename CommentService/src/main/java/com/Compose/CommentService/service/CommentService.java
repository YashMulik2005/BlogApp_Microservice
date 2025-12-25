package com.Compose.CommentService.service;

import com.Compose.CommentService.dto.CommentCreationResponseDto;
import com.Compose.CommentService.dto.CommentRequestDto;
import com.Compose.CommentService.dto.CommentResponseDto;

import java.util.List;

public interface CommentService {
    CommentCreationResponseDto addComment(CommentRequestDto commentRequestDto);
    CommentCreationResponseDto updateComment(Long id, CommentRequestDto commentRequestDto);
    void deleteComment(Long id);
    List<CommentResponseDto> commentByPostId(Long id);
}
