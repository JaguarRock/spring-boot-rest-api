package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiResponse;
import com.example.model.Board;
import com.example.service.BoardService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping
	public ApiResponse<Board> saveBoard(@RequestBody Board board) {
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
	public ApiResponse<Board> update(@RequestBody Board board) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Board Update", boardService.update(board));
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse<Void> delete(@PathVariable Long id) {
		boardService.delete(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "Board delete", null);
	}
}
