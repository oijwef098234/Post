package com.example.post.domain.repository;

import com.example.post.domain.entity.CommentOfCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentOfCommentRepository extends JpaRepository<CommentOfCommentEntity, Long> {
}
