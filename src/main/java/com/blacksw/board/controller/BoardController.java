package com.blacksw.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blacksw.board.dto.BoardDTO;
import com.blacksw.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public List<BoardDTO> getBoardList() {
		return null;
	}
	
	@PostMapping("/board")
	public void insertBoard(@RequestBody BoardDTO board) {
		
	}
	
	@GetMapping("/board/{boardId}")
	public BoardDTO getBoard(@PathVariable("boardId") int boardId) {
		return null;
	}
	
	@PutMapping("/board/{boardId}")
	public String updateBoard(@RequestBody BoardDTO board) {
		return "redirect:/board/list/1";
	}
	
	@PutMapping("/board{boardId}")
	public String deleteBoard(@PathVariable("boardId") int boardId) {
		return "redirect:/board/list/1";
	}
	
}
