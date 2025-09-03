package com.example.post.domain.service;

import com.example.post.domain.dto.request.CommentRequest;
import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.CommentRepository;
import com.example.post.domain.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateComment {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void createComment(Long postId, CommentRequest comment) {
        PostEntity post = postRepository.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("게시글이 존재하지 않습니다.")
        );

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setPostEntity(post);
        commentEntity.setContent(comment.getComment());

        commentRepository.save(commentEntity);
    }

}
