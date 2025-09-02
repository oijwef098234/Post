package com.example.post.domain.dto.response;

import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.PostEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PostAndCommentResponse {
    private PostEntity post;
    private List<CommentResponse> comment;
}
