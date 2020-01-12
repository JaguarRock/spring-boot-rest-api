package com.example.demo.service.impl;

import com.example.demo.model.Board;
import com.example.demo.respository.BoardRepository;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public Board save(Board board) {
        board = new Board();
        board.setId(board.getId());
        board.setTitle(board.getTitle());
        board.setContent(board.getContent());
        return boardRepository.save(board);
    }

    @Override
    public List<Board> findAll() {
        List<Board> boardList = new ArrayList<>();
        boardRepository.findAll().iterator().forEachRemaining(boardList::add);
        return boardList;
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Board findById(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return board.isPresent() ? board.get() : null;
    }

    @Override
    public Board update(Board board) {
        board = findById(board.getId());
        if(board != null) {
            boardRepository.save(board);
        }
        return board;
    }
}
