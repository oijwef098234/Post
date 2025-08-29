package com.example.post.domain.service;

import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.CommentRepository;
import com.example.post.domain.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateComment {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public void updateComment(Long commentId, String comment){
        CommentEntity commentEntity = commentRepository.findById(commentId).orElseThrow(
                () -> new EntityNotFoundException("id에 해당하는 게시글을 찾을 수 없습니다")
        );

        commentEntity.updateComment(comment);

        commentRepository.save(commentEntity);
    }
}
