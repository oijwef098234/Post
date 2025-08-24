package com.example.post.domain.service;

import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadPost {
    private final PostRepository postRepository;

    public PostEntity readPost(Long id){
        PostEntity result = postRepository.findById(id).orElse(null);
        return result;
    }
    public List<PostEntity> readAllPosts(){
        return postRepository.findAll();
    }
}
