package com.example.post.domain.controller;

import com.example.post.domain.dto.request.PostRequest;
import com.example.post.domain.dto.response.PostAndCommentResponse;
import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final CreatePost createPost;
    private final UpdatePost updatePost;
    private final ReadPost readPost;
    private final DeletePost deletePost;

    @PostMapping("/create") // 게시글 만들기
    public ResponseEntity<String> createPost(@RequestBody PostRequest postRequest){
        String result = createPost.create(postRequest);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}") // 게시글 수정하기
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest){
        String result = updatePost.updatePost(id, postRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}") // 게시글 id로 불러오기
    public PostEntity readPost(@PathVariable Long id){
        PostEntity postEntity = readPost.readPost(id);
        return postEntity;
    }

    @GetMapping("/all") // 게시글 전체 불러오기
    public List<PostEntity> readAllPosts(){
        List<PostEntity> postEntities = readPost.readAllPosts();
        return postEntities;
    }

    @DeleteMapping("/{id}") // 게시글 삭제하기
    public void deletePost(@PathVariable Long id){
        deletePost.deletePost(id);
    }
}
