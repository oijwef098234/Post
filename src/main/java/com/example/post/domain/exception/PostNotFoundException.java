package com.example.post.domain.exception;

import com.example.post.global.error.exception.ErrorCode;
import com.example.post.global.error.exception.PostException;

public class PostNotFoundException extends PostException {
    public static final PostException EXCEPTION = new PostNotFoundException();
    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
