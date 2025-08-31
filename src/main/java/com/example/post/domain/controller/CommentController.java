package com.example.post.domain.controller;

import com.example.post.domain.dto.response.PostAndCommentResponse;
import com.example.post.domain.entity.CommentEntity;
import com.example.post.domain.entity.PostEntity;
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

    @PostMapping("/create")
    public ResponseEntity<String> createComment(@RequestBody PostEntity postEntity, String comment){
        createComment.createComment(postEntity, comment);

        return ResponseEntity.ok("댓글이 생성되었습니다");
    }

    @PatchMapping("/{id}") // 댓글 수정하기
    public ResponseEntity<String> updateComment(@PathVariable Long id, @RequestBody String comment){
        updateComment.updateComment(id, comment);

        return ResponseEntity.ok("수정되었습니다");
    }

    @GetMapping("/{id}") // 댓글 id로 불러오기
    public ResponseEntity<List<CommentEntity>> readAllComment(@PathVariable Long PostId){
        List<CommentEntity> result = readComment.readAllComments(PostId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/all") // 게시글 전체 불러오기
    public ResponseEntity<PostAndCommentResponse> readPostAndComments(Long postId){
        PostAndCommentResponse result = readComment.readPostAndComments(postId);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        String result = deleteComment.deleteComment(id);

        return ResponseEntity.ok(result);
    }
}
// 지금 controller에서 댓글을 매핑된 메서드안에 집어넣지도 못하고 있고 또한 지피티가 추천해준 방식을 보니 PostEnitity를 받는것이 아닌 postId를 받는거기 떄문에
// entity도 고치고 다른것들을 다 고쳐야할거 같음 ㅇㅇ
