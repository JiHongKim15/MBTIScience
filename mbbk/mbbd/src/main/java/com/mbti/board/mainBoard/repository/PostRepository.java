package com.mbti.board.mainBoard.repository;

import com.mbti.board.mainBoard.dto.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("update Post p set p.views = p.views + 1 where p.postNo = :postNo")
    @Modifying
    void increaseViews(long postNo);
}
