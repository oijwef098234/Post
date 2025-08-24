package com.example.post.domain.service;

import com.example.post.domain.dto.request.PostRequest;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatePost {
    private final PostRepository postRepository;

    @Transactional
    public String updatePost(PostRequest postRequest){
        String title = postRequest.getTitle();
        String content = postRequest.getContent();

        PostEntity postEntity = new PostEntity();

        postEntity.updatePost(title, content);

        postRepository.save(postEntity);

        return "수정되었습니다.";
    }
}
