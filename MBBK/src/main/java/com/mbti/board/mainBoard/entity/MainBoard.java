package com.mbti.board.mainBoard.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class MainBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mainBoardNum;

    private String title;
    private String content;
    private String writer;

    @LastModifiedDate
    private LocalDateTime writeTime;

}
