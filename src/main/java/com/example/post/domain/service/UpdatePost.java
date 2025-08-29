package com.example.post.domain.service;

import com.example.post.domain.dto.request.PostRequest;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePost {
    private final PostRepository postRepository;

    public String updatePost(Long id, PostRequest postRequest){
        String title = postRequest.getTitle();
        String content = postRequest.getContent();

        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(id + "에 해당하는 게시글이 존재하지 않습니다")
        );

        postEntity.updatePost(title, content);

        postRepository.save(postEntity);

        return "게시글이 수정되었습니다.";
    }
}
