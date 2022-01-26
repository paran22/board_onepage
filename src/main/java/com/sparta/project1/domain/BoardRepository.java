package com.sparta.project1.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //createdAt을 기준으로 내림차순(desc, 최신순) 정렬
    List<Board> findAllByOrderByCreatedAtDesc();

}
