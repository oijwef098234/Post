package com.example.post.domain.service;

import com.example.post.domain.dto.response.CommentResponse;
import com.example.post.domain.dto.response.PostWithCommentResponse;
import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.CommentRepository;
import com.example.post.domain.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadComment {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 게시글의 id에 해당하는 댓글만 읽어오기
    public List<CommentEntity> onlyComments(Long postId) {

    }

    // 게시글과 댓글을 동시에 읽어오기
    public PostWithCommentResponse postWithComments(Long postId) {
        PostEntity post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("게시글을 찾을 수 없습니다")
        );
        List<String> comments = onlyComments(postId);

        PostWithCommentResponse postWithCommentResponse = new PostWithCommentResponse();

        postWithCommentResponse.setPost(post);
        postWithCommentResponse.setComments(comments);

        return postWithCommentResponse;
    }

}
