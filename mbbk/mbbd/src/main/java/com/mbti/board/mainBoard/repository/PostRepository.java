package com.mbti.board.mainBoard.repository;

import com.mbti.board.mainBoard.dto.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
