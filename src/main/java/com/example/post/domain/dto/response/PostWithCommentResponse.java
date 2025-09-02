package com.example.post.domain.dto.response;

import com.example.post.domain.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostWithCommentResponse {
    private PostEntity post;
    private List<CommentResponse> comments;
}
