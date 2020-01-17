package com.example.demo.service.impl;

import com.example.demo.model.Board;
import com.example.demo.model.BoardDTO;
import com.example.demo.respository.BoardRepository;
import com.example.demo.service.BoardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board save(BoardDTO board) {
        Board newBoard = new Board();
        newBoard.setTitle(board.getTitle());
        newBoard.setContent(board.getContent());
        return boardRepository.save(newBoard);
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
    public BoardDTO update(BoardDTO boardDTO) {
        Board board = findById(boardDTO.getId());
        if(board != null) {
            boardRepository.save(board);
        }
        return boardDTO;
    }
}
