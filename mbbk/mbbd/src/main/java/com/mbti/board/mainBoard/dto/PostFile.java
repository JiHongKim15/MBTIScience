package com.mbti.board.mainBoard.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    //TODO: 저장위치 변경(현재 주석처리)
    static public PostFile toPostFile(MultipartFile file, Post post){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmSS_");
        String hashName = dateFormat.format(cal.getTime() + file.getOriginalFilename());
//        file.transferTo(new File("/Users/lsy/Desktop/toy/img/" + hashName));
        return PostFile.builder()
                .post(post)
                .originName(file.getOriginalFilename())
                .hashName(hashName)
                .fileExt(file.getContentType())
                .fileSize(file.getSize())
                .filePath("/Users/lsy/Desktop/toy/img/" + hashName)
                .build();
    }


}
