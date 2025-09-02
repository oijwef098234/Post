package com.example.post.domain.dto.response;

import com.example.post.domain.entity.CommentEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentResponse {
    private CommentEntity comment;
}
