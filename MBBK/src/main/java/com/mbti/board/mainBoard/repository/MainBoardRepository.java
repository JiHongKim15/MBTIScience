package com.mbti.board.mainBoard.repository;


import com.mbti.board.mainBoard.entity.MainBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface MainBoardRepository extends JpaRepository<MainBoard, Integer> {

    MainBoard findByMainBoardNum(int mainBoardNum);
    void deleteByMainBoardNum(int mainBoardNum);
}
