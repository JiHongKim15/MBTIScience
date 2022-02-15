package com.mbti.board.mainBoard.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    private int mainBoardNum;
    private String comment;
    private String writer;
    private Date writeTime;

}
