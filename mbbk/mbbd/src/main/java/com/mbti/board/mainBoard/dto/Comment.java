package com.mbti.board.mainBoard.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentNo;

    @ManyToOne
    @JoinColumn(name = "post_no", referencedColumnName = "postNo")
    @JsonBackReference
    private Post post;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime insDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updDate;


    @Getter
    @Setter
    public static class CommentForUpdate{

        private long commentNo;

        private String author;

        private String text;
    }
}
