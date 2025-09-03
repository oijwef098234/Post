package com.example.post.domain.controller;

import com.example.post.domain.dto.request.CommentRequest;
import com.example.post.domain.dto.response.CommentResponse;
import com.example.post.domain.dto.response.PostWithCommentResponse;
import com.example.post.domain.service.CreateComment;
import com.example.post.domain.service.DeleteComment;
import com.example.post.domain.service.ReadComment;
import com.example.post.domain.service.UpdateComment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CreateComment createComment;
    private final UpdateComment updateComment;
    private final ReadComment readComment;
    private final DeleteComment deleteComment;

    @PostMapping("/{id}")
    public ResponseEntity<String> createComment(@PathVariable Long id, @RequestBody CommentRequest comment){
        createComment.createComment(id, comment);

        return ResponseEntity.ok("댓글이 생성되었습니다");
    }

    @PatchMapping("/{id}") // 댓글 수정하기
    public ResponseEntity<String> updateComment(@PathVariable Long id, @RequestBody String comment){
        updateComment.updateComment(id, comment);

        return ResponseEntity.ok("수정되었습니다");
    }
    // 댓글만 불러오기
    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentResponse>> readComment(@PathVariable Long postId){
        List<CommentResponse> results =  readComment.onlyComments(postId);

        return ResponseEntity.ok(results);
    }
    @GetMapping("/all/{postId}")
    public ResponseEntity<PostWithCommentResponse> readAllComments(@PathVariable Long postId){
        PostWithCommentResponse postWithCommentResponse = readComment.postWithComments(postId);

        return ResponseEntity.ok(postWithCommentResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        String result = deleteComment.deleteComment(id);

        return ResponseEntity.ok(result);
    }
}