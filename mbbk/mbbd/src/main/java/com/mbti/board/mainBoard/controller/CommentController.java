package com.mbti.board.mainBoard.controller;

import com.mbti.board.mainBoard.controller.bind.ApiResult;
import com.mbti.board.mainBoard.dto.Comment;
import com.mbti.board.mainBoard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ApiResult<String> create(
        @RequestBody @Valid Comment comment
    ){
        commentService.createComment(comment);
        return ApiResult.success(null, HttpStatus.OK);
    }

    @PatchMapping
    public ApiResult<String> update(
            @RequestBody @Valid Comment.CommentForUpdate comment
    ){
        commentService.updateComment(comment);
        return ApiResult.success(null, HttpStatus.OK);
    }

    @DeleteMapping
    public ApiResult<String> delete(
            @RequestParam String author,
            @RequestParam long commentNo
    ){
        commentService.deleteComment(author, commentNo);
        return ApiResult.success(null, HttpStatus.OK);
    }

}
