package com.example.post.domain.service;

import com.example.post.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteComment {
    private final CommentRepository commentRepository;

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
