package com.mbti.board.mainBoard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbti.board.mainBoard.dto.PostFile;
import com.mbti.board.mainBoard.exception.BusinessException;
import com.mbti.board.mainBoard.dto.Post;
import com.mbti.board.mainBoard.repository.CommentRepository;
import com.mbti.board.mainBoard.repository.PostFileRepository;
import com.mbti.board.mainBoard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//TODO: 필요없는 예외호출부분은 로직 정리하면서 제거

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostFileRepository postFileRepository;

    @Transactional(rollbackFor = BusinessException.class)
    public void createPost(Post post, List<MultipartFile> files){
        try {
            postRepository.save(post);
            postFileRepository.saveAll(toPostFile(post, files));
        } catch(BusinessException e){
            throw new BusinessException("글 저장 중 오류가 발생했습니다.", e);
        }
    }


    @Transactional(readOnly = true)
    public List<Post.postForBoard> readPostList(int page, int limit){
        try {
            List<Post> postList = postRepository.findAll(PageRequest.of(page - 1, limit, Sort.by("insDate").descending())).toList();
            return postList.stream().map(Post::of).collect(Collectors.toList());
        } catch(BusinessException e){
            throw new BusinessException("글 리스트 조회 중 오류가 발생했습니다.", e);
        }
    }

    @Transactional(rollbackFor = BusinessException.class)
    public Post readPostDetail(long postNo){
        Post post = postRepository.findById(postNo)
            .orElseThrow(() -> new BusinessException("글 정보가 존재하지 않습니다."));
        postRepository.increaseViews(postNo);
        post.setComments(commentRepository.findAllByPost(post));
        post.setPostFiles(postFileRepository.findAllByPost(post));
        return post;
    }

    //TODO: 파일 업뎃로직 수정... 전체삭제 -> 추가 to 변경사항만 변경하기
    @Transactional(rollbackFor = BusinessException.class)
    public void updatePost(Post.PostForUpdate postForUpdate, List<MultipartFile> files){
        Post post = postRepository.findById(postForUpdate.getPostNo())
                .orElseThrow(() -> new BusinessException("기존 글 정보가 존재하지 않습니다."));

        if(post.getAuthor().equals(postForUpdate.getAuthor())){
            try {
                postRepository.save(post);
//                deleteFile(postFileRepository.findAllByPost(post));
                postFileRepository.deletePostFilesByPost(post);
                postFileRepository.saveAll(toPostFile(post, files));
            } catch(BusinessException e){
                throw new BusinessException("글 수정 중 오류가 발생했습니다.", e);
            }
        }
        else{
            throw new BusinessException("기존 글과 수정 요청된 글의 정보가 서로 다릅니다.");
        }


    }

    //TODO: 유저 검증 작업 필요, 임시처리
    @Transactional(rollbackFor = BusinessException.class)
    public void deletePost(String author, long postNo) throws BusinessException{

        Post post = postRepository.findById(postNo)
                .orElseThrow(() -> new BusinessException("기존 글 정보가 존재하지 않습니다."));

        if(post.getAuthor().equals(author)){
            try{
//                deleteFile(postFileRepository.findAllByPost(post));
                postRepository.deleteById(postNo);
            }catch (BusinessException e){
                throw new BusinessException("글 삭제 중 오류가 발생했습니다.", e);
            }
        }
        else {
            throw new BusinessException("삭제하려는 글 정보에 문제가 있습니다.");
        }
    }


    private List<PostFile> toPostFile(Post post, List<MultipartFile> files) {
        if(files != null && !files.isEmpty()){
            return files.stream()
                    .map(file -> PostFile.toPostFile(file, post))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public void deleteFile(List<PostFile> postFiles){
        for(PostFile postFile : postFiles){
            File file = new File(postFile.getFilePath());
            if(file.isFile()){
                file.delete();
            }
        }
    }


}
