package com.mbti.board.mainBoard.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*; 

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
