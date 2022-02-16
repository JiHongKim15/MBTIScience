package com.mbti.board.mainBoard.repository;

import com.mbti.board.mainBoard.dto.Comment;
import com.mbti.board.mainBoard.dto.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findAllByPost(Post post);
}
