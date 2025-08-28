package com.example.post.domain.repository;

import com.example.post.domain.dto.response.PostResponse;
import com.example.post.domain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Optional<PostResponse> findByFeedId(Long id);
    List<PostResponse> findAllByFeed();
}
