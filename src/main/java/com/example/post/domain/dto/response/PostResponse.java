package com.example.post.domain.dto.response;

import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.CommentOfCommentEntity;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Setter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private Optional<List<CommentEntity>> comment;
    private Optional<List<CommentOfCommentEntity>>  comments;
}
