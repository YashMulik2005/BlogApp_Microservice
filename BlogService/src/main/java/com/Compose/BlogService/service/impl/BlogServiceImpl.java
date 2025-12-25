package com.Compose.BlogService.service.impl;

import com.Compose.BlogService.dto.BlogRequestDto;
import com.Compose.BlogService.dto.BlogResponseDto;
import com.Compose.BlogService.dto.BlogSearchResponseDto;
import com.Compose.BlogService.dto.SingleBlogDetaliedDto;
import com.Compose.BlogService.model.Blog;
import com.Compose.BlogService.repository.BlogRepository;
import com.Compose.BlogService.service.AuthClient;
import com.Compose.BlogService.service.BlogService;
import com.Compose.BlogService.service.CommentClient;
import jakarta.ws.rs.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthClient authClient;

    @Autowired
    private CommentClient commentClient;

    @Override
    public BlogResponseDto addBlog(BlogRequestDto blogRequestDto) {
        Blog blog = modelMapper.map(blogRequestDto, Blog.class);
        blog.setId(null);
        blog.setUserId(blogRequestDto.getUserId());
        Blog savedBlog = blogRepository.save(blog);
        return modelMapper.map(savedBlog, BlogResponseDto.class);
    }

    @Override
    public List<BlogResponseDto> getBlogs() {
        List<Blog> blogs = blogRepository.findAll();

        return blogs.stream().map(blog -> modelMapper.map(blog, BlogResponseDto.class)).toList();
    }

    @Override
    public SingleBlogDetaliedDto getSingleBlog(Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Blog not found with id "+id));

        SingleBlogDetaliedDto res = modelMapper.map(blog, SingleBlogDetaliedDto.class);
        res.setUser(authClient.getUserDetails(blog.getUserId()));
        res.setComments(commentClient.getCommentByBlogId(blog.getId()));
        return res;
    }

    @Override
    public BlogResponseDto updateBlog(Long id, BlogRequestDto blogRequestDto) {
        return null;
    }

    @Override
    public void deleteBlog(Long id) {

    }

    @Override
    public List<BlogSearchResponseDto> searchBlog(String title) {
        List<Blog> blogs = blogRepository.findByTitleContainingIgnoreCase(title);

        return blogs.stream().map(blog -> modelMapper.map(blog, BlogSearchResponseDto.class)).toList();
    }
}
