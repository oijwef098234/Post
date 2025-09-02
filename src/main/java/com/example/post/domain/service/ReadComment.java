package com.example.post.domain.service;

import com.example.post.domain.dto.response.CommentResponse;
import com.example.post.domain.dto.response.PostAndCommentResponse;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.CommentRepository;
import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadComment {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public List<CommentResponse> readAllComments(Long postId){
        List<CommentResponse> results = commentRepository.findByPostEntityId(postId);

        return results;
    }

    public PostAndCommentResponse readPostAndComments(Long postId){
        PostEntity post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("id에 해당하는 게시글이 존재하지 않습니다")
        );

        List<CommentResponse> comment = commentRepository.findByPostEntityId(postId);

        PostAndCommentResponse result = new PostAndCommentResponse();

        result.setComment(comment);
        result.setPost(post);

        return result;
    }
}
