package com.example.post.domain.service;

import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.CommentRepository;
import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateComment {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void createComment(Long postId, String comment) {
        PostEntity post = postRepository.findById(postId).get();

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setPostEntity(post);
        commentEntity.setContent(comment);

        commentRepository.save(commentEntity);
    }

}
