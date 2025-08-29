package com.example.post.domain.dto.response;

import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.PostEntity;
import lombok.Setter;

import java.util.List;

@Setter
public class PostAndCommentResponse {
    private List<CommentEntity> comment;
    private PostEntity post;
}
