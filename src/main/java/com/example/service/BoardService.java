package com.example.service;

import java.util.List;


import com.example.model.Board;

public interface BoardService {
	
	Board save(Board board);
	
	List<Board> findAll();
	
	void delete(Long id);
	
	Board findById(Long id);
	
	Board update(Board board);
}
