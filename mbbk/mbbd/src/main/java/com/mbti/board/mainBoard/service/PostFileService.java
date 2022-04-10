package com.mbti.board.mainBoard.service;

import com.mbti.board.mainBoard.dto.Post;
import com.mbti.board.mainBoard.dto.PostFile;
import com.mbti.board.mainBoard.exception.BusinessException;
import com.mbti.board.mainBoard.repository.PostFileRepository;
import com.mbti.board.mainBoard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFileService {
    private final PostFileRepository postFileRepository;
    private final PostRepository postRepository;
    
    @Transactional(rollbackFor = BusinessException.class)
    public void insertBoardFile(List<MultipartFile> files, Post post) {
        try {
            saveFile(files, post);
        } catch (BusinessException | IOException e) {
            throw new BusinessException("파일 저장 중 오류가 발생했습니다.", e);
        }
    }

    @Transactional(rollbackFor = BusinessException.class)
    public void updateBoardFile(List<MultipartFile> files, Post.PostForUpdate postForUpdate) {
        try {
            Post post = postRepository.findById(postForUpdate.getPostNo()).get();
            postFileRepository.deletePostFilesByPost(post);
            deleteFile(post);
            saveFile(files, post);
        } catch (BusinessException | IOException e) {
            throw new BusinessException("파일 수정 중 오류가 발생했습니다.", e);
        }
    }

    public void saveFile(List<MultipartFile> files, Post post) throws IOException {
        List<PostFile> postFiles = new ArrayList<>();
        for(MultipartFile file : files){
            String originName = file.getOriginalFilename();
            Calendar cal = Calendar.getInstance()  ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmSS_");
            String hashName = dateFormat.format(cal.getTime()) + originName;
            //TODO: 저장 위치 변경
            String filePath = "/Users/lsy/Desktop/toy/img/" + hashName;
            System.out.println("방금 생성된 파일명 : " +filePath);

            PostFile postFile = PostFile.builder()
                    .post(post)
                    .originName(originName)
                    .hashName(hashName)
                    .fileExt(file.getContentType())
                    .fileSize(file.getSize())
                    .filePath(filePath)
                    .build();

            File destination = new File(filePath);
            file.transferTo(destination);
            postFiles.add(postFile);
        }
        postFileRepository.saveAll(postFiles);
    }

    public void deleteFile(Post post){
        List<PostFile> postFiles = post.getPostFiles();
        for(PostFile postFile : postFiles){
            File file = new File(postFile.getFilePath());
            if(file.isFile()){
                file.delete();
            }
        }
    }

}
