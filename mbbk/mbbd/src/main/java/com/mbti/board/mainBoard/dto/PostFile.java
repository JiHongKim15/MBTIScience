package com.mbti.board.mainBoard.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class PostFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fileNo;

    @ManyToOne
    @JoinColumn(name = "post_no", referencedColumnName = "postNo")
    @JsonBackReference
    private Post post;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String hashName;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private String fileExt;

    @Column(nullable = false)
    private long fileSize;


}
