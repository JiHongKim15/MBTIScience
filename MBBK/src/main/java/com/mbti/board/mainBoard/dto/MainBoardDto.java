package com.mbti.board.mainBoard.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class MainBoardDto {

    private int mainBoardNum;
    private String title;
    private String content;
    private String writer;
    private Date writeTime;

}
