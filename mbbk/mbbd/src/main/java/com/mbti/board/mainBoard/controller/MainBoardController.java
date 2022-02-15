package com.mbti.board.mainBoard.controller;

import com.mbti.board.mainBoard.dto.MainBoardDto;
import com.mbti.board.mainBoard.entity.MainBoard;
import com.mbti.board.mainBoard.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MainBoardController {

    @Autowired
    private MainBoardService mainBoardSerivce;

    @GetMapping
    public List<MainBoard> retrieveMainBoardAll(){
        return mainBoardSerivce.retrieveMainBoardAll();
    }

    @GetMapping("/detail")
    public MainBoard retrieveMainBoard(int mainBoardNum){
        return mainBoardSerivce.retrieveMainBoard(mainBoardNum);
    }

    @PostMapping
    public ResponseEntity<MainBoard> createMainBoardContent(@RequestBody MainBoard mainBoard){
        return new ResponseEntity<MainBoard>(mainBoardSerivce.createMainBoardContent(mainBoard), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MainBoard> updateMainBoardContent(@RequestBody MainBoard mainBoard){
        return new ResponseEntity<MainBoard>(mainBoardSerivce.updateMainBoardContent(mainBoard), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteMainBoardContent(int mainBoardNum){
        mainBoardSerivce.deleteMainBoardContent(mainBoardNum);
    }

}
