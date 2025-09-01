package com.example.post.domain.controller;

import com.example.post.domain.dto.response.PostAndCommentResponse;
import com.example.post.domain.entity.CommentEntity;
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
    public ResponseEntity<String> createComment(@PathVariable Long id, @RequestBody String comment){
        createComment.createComment(id, comment);

        return ResponseEntity.ok("댓글이 생성되었습니다");
    }

    @PatchMapping("/{id}") // 댓글 수정하기
    public ResponseEntity<String> updateComment(@PathVariable Long id, @RequestBody String comment){
        updateComment.updateComment(id, comment);

        return ResponseEntity.ok("수정되었습니다");
    }

    @GetMapping("/read-comment/{id}") // 댓글 id로 불러오기
    public ResponseEntity<List<CommentEntity>> readAllComment(@PathVariable Long id){
        List<CommentEntity> result = readComment.readAllComments(id);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/all/{id}") // 게시글 전체 불러오기
    public ResponseEntity<PostAndCommentResponse> readPostAndComments(@PathVariable Long id){
        PostAndCommentResponse result = readComment.readPostAndComments(id);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        String result = deleteComment.deleteComment(id);

        return ResponseEntity.ok(result);
    }
}