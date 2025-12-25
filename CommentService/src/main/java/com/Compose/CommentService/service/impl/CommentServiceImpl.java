package com.Compose.CommentService.service.impl;

import com.Compose.CommentService.dto.CommentCreationResponseDto;
import com.Compose.CommentService.dto.CommentRequestDto;
import com.Compose.CommentService.dto.CommentResponseDto;
import com.Compose.CommentService.dto.userDtos.UserDetailsResponseDto;
import com.Compose.CommentService.model.Comment;
import com.Compose.CommentService.repository.CommentRepository;
import com.Compose.CommentService.service.AuthClient;
import com.Compose.CommentService.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthClient authClient;

    @Override
    public CommentCreationResponseDto addComment(CommentRequestDto commentRequestDto) {
        Comment comment = new Comment();
        comment.setContent(commentRequestDto.getContent());
        comment.setPost_id(commentRequestDto.getPostId());
        comment.setUserId(commentRequestDto.getUserId());
        Comment savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment , CommentCreationResponseDto.class);
    }

    @Override
    public CommentCreationResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {

    }

    @Override
    public List<CommentResponseDto> commentByPostId(Long id) {
        List<Comment> comments = commentRepository.findByPostId(id);

        return comments.stream()
                .map(comment -> {
                    UserDetailsResponseDto userData = authClient.getUserDetails(comment.getUserId());
                    CommentResponseDto commentData = modelMapper.map(comment, CommentResponseDto.class);
                    commentData.setUser(userData);
                    return commentData;
                }).toList();
    }
}
