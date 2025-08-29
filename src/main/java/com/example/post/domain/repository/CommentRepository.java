package com.example.post.domain.repository;

import com.example.post.domain.dto.response.CommentsResponse;
import com.example.post.domain.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<List<CommentsResponse>> findByAllComment(Long postId);
}
