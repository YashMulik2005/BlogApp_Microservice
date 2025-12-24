package com.Compose.BlogService.repository;

import com.Compose.BlogService.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Optional<Blog> findById(Long id);
    List<Blog> findByTitleContainingIgnoreCase(String title);
}
