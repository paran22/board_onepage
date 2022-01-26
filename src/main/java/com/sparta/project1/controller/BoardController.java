package com.sparta.project1.controller;

import com.sparta.project1.domain.Board;
import com.sparta.project1.domain.BoardRepository;
import com.sparta.project1.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;

    //게시글 등록하기
    @PostMapping("/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    //게시글 보기
    @GetMapping("/boards")
    public List<Board> getBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    //게시글 상세보기
    //findById는 반드시 orElseThrow를 해야 Board로 저장되는 것 같다.
    @GetMapping("/boards/{id}")
    public Board getBoardOne(@PathVariable Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        return board;
    }

}
