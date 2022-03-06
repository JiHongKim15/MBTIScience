package com.mbti.board.mainBoard.repository;

import com.mbti.board.mainBoard.dto.PostFile;
import com.mbti.board.mainBoard.dto.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostFileRepository extends JpaRepository<PostFile, Long> {
    public List<PostFile> findAllByPost(Post post);
    public void deletePostFilesByPost(Post post);
}
