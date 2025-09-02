package com.example.post.domain.service;

import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePost {
    private final PostRepository postRepository;

    public String deletePost(Long id){
        postRepository.deleteById(id);

        return id + "번 게시글이 삭제되었습니다.";
    }
}
