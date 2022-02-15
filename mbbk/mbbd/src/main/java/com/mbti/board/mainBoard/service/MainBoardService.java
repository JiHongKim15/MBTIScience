package com.mbti.board.mainBoard.service;

import com.mbti.board.mainBoard.entity.MainBoard;

import java.util.List;


public interface MainBoardService {

    public List<MainBoard> retrieveMainBoardAll();
    public MainBoard retrieveMainBoard(int mainBoardNum);
    public MainBoard createMainBoardContent(MainBoard mainBoard);
    public MainBoard updateMainBoardContent(MainBoard mainBoard);
    public void deleteMainBoardContent(int mainBoardNum);

}
