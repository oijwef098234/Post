package com.example.post.domain.service;

import com.example.post.domain.dto.request.PostRequest;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePost {
    private final PostRepository postRepository;

    public String create(PostRequest postRequest) {
        PostEntity postEntity = new PostEntity(); // 여기서 빈 게시글을 만든다.

        postEntity.setTitle(postRequest.getTitle()); // 빈 게시글에 요청에서 가져온 title을 넣는다.
        postEntity.setContent(postRequest.getContent()); // 빈 게시글에 요청에서 가져온 content를 넣는다.

        postRepository.save(postEntity); // 새롭게 set된 게시글을 save해준다.

        return "게시글이 생성되었습니다.";
    }
}
