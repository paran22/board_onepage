package com.sparta.project1.controller;

import com.sparta.project1.domain.Board;
import com.sparta.project1.domain.BoardRequestDto;
import com.sparta.project1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //게시글 등록하기
    @PostMapping("/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = boardService.createdBoard(requestDto);
        return board;
    }

    //게시글 목록 조회하기
    @GetMapping("/boards")
    public List<Board> getBoard() {
        List<Board> board = boardService.getBoard();
        return board;
    }

    //게시글 조회하기
    @GetMapping("/boards/{id}")
    public Board getBoardOne(@PathVariable Long id){
        Board board = boardService.getBoardOne(id);
        return board;
    }

}
