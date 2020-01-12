package com.example.demo.service;

import com.example.demo.model.Board;

import java.util.List;

public interface BoardService {

    Board save(Board board);

    List<Board> findAll();

    void delete(Long id);

    Board findById(Long id);

    Board update(Board board);
}
