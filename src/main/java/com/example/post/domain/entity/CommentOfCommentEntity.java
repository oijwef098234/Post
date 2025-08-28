package com.example.post.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentOfCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentEntity commentEntity;

    public void updateCommentOfCommentEntity(String comment) {
        this.comment = comment;
    }
}
