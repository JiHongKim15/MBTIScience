package com.mbti.board.mainBoard.service;

import com.mbti.board.mainBoard.dto.Post;
import com.mbti.board.mainBoard.dto.PostFile;
import com.mbti.board.mainBoard.exception.BusinessException;
import com.mbti.board.mainBoard.repository.PostFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostFileService {
    private final PostFileRepository postFileRepository;

    //TODO: 업로드 파일 개수 제한
    @Transactional(rollbackFor = BusinessException.class)
    public void insertBoardFile(Post post) {
        try {
            List<PostFile> postFiles = post.getPostFiles();
            postFileRepository.saveAll(postFiles);
        } catch (BusinessException e) {
            throw new BusinessException("파일 저장 중 오류가 발생했습니다.", e);
        }
    }

    @Transactional(rollbackFor = BusinessException.class)
    public void deleteBoardFile(Post post) {
        try {


        } catch (BusinessException e) {
            throw new BusinessException("파일 삭제 중 오류가 발생했습니다.", e);
        }
    }

    @Transactional(rollbackFor = BusinessException.class)
    public void updateBoardFile(Post post) {
        try {


        } catch (BusinessException e) {
            throw new BusinessException("파일 수정 중 오류가 발생했습니다.", e);
        }
    }

}
