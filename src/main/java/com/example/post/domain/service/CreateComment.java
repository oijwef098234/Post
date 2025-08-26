package com.example.post.domain.service;

import com.example.post.domain.dto.request.CommentRequest;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateComment {
    private PostRepository postRepository;

    public PostEntity createComment(Long postId, CommentRequest commentRequest) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("삭제된 게시글입니다.")
        );

        postEntity.setComment(commentRequest.getComment());
        postRepository.save(postEntity);

        return postEntity;
    }
}
 