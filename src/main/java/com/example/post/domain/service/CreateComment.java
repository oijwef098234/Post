package com.example.post.domain.service;

import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.CommentOfCommentEntity;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.CommentOfCommentRepository;
import com.example.post.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateComment {
    private final CommentRepository commentRepository;
    private final CommentOfCommentRepository commentOfCommentRepository;

    public void createComment(PostEntity post, String comment) {
        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setComment(comment);
        commentEntity.setPostEntity(post);

        commentRepository.save(commentEntity);
    }

    public void createCommentOfComment(CommentEntity commentEntity, String comment) {
        CommentOfCommentEntity commentOfCommentEntity = new CommentOfCommentEntity();

        commentOfCommentEntity.setCommentEntity(commentEntity);

        commentOfCommentEntity.setComment(comment);

        commentOfCommentRepository.save(commentOfCommentEntity);
    }
}
