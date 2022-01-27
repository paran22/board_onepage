package com.sparta.project1.service;

import com.sparta.project1.domain.Board;
import com.sparta.project1.domain.BoardRepository;
import com.sparta.project1.domain.BoardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //게시글 등록하기
    public Board createdBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return board;
    }

    //게시글 목록 조회하기
    public List<Board> getBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    //게시글 조회하기
    public Board getBoardOne(Long id) {
        Board board = boardRepository.findById(id).
                orElseThrow(() -> new NullPointerException("아이디가 존재하지 않습니다."));
        return board;
    }
}
