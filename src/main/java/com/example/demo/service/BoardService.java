package com.example.demo.service;

import com.example.demo.model.Board;
import com.example.demo.model.BoardDTO;

import java.util.List;

public interface BoardService {

    Board save(BoardDTO board);

    List<Board> findAll();

    void delete(Long id);

    Board findById(Long id);

    BoardDTO update(BoardDTO board);
}
