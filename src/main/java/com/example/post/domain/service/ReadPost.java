package com.example.post.domain.service;

import com.example.post.domain.dto.response.CommentsResponse;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.CommentRepository;
import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadPost {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostEntity readPost(Long id){
        PostEntity result = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 해당하는 글이 존재하지 않습니다")
        );
        return result;
    }
    public List<PostEntity> readAllPosts(){
        return postRepository.findAll();
    }

    public List<CommentsResponse>  readAllComments(Long postId){
        List<CommentsResponse> results = commentRepository.findByAllComment(postId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        return results;
    }
}
