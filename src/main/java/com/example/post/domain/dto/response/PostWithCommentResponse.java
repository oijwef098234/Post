package com.example.post.domain.dto.response;

import com.example.post.domain.entity.PostEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostWithCommentResponse {
    private PostEntity post;
    private List<CommentResponse> comments;
}
