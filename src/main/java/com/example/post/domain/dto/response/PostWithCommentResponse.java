package com.example.post.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostWithCommentResponse {
    private Long id;
    private String title;
    private String content;
    private List<String> comment;
}
