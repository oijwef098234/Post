package com.example.post.domain.controller;

import com.example.post.domain.dto.request.PostRequest;
import com.example.post.domain.dto.response.PostResponse;
import com.example.post.domain.entity.PostEntity;
import com.example.post.domain.service.CreatePost;
import com.example.post.domain.service.DeletePost;
import com.example.post.domain.service.ReadPost;
import com.example.post.domain.service.UpdatePost;
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

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody PostRequest postRequest){
        String result = createPost.create(postRequest);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest){
        String result = updatePost.updatePost(id, postRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public PostResponse readPost(@PathVariable Long id){
        PostResponse postEntity = readPost.readPost(id);
        return postEntity;
    }

    @GetMapping("/all")
    public List<PostEntity> readAllPosts(){
        List<PostEntity> postEntities = readPost.readAllPosts();
        return postEntities;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        deletePost.deletePost(id);
    }
}
