package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.Board;
import com.example.demo.model.BoardDTO;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public ApiResponse<Board> saveBoard(@RequestBody BoardDTO board) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Board saved", boardService.save(board));

    }

    @GetMapping
    public ApiResponse<List<Board>> listBoard() {
        return new ApiResponse<>(HttpStatus.OK.value(), "Board list", boardService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Board> getOne(@PathVariable Long id) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Board", boardService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<Board> update(@RequestBody BoardDTO board) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Board Update", boardService.update(board));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Board delete", null);
    }
}
