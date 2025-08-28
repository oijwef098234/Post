package com.example.post.domain.service;

import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.repository.CommentOfCommentRepository;
import com.example.post.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteComment {
    private final CommentRepository commentRepository;
    private final CommentOfCommentRepository commentOfCommentRepository;

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void deleteCommentOfComment(Long commentId) {
        commentOfCommentRepository.deleteById(commentId);
    }
}
