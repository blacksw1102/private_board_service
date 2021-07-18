package com.blacksw.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blacksw.board.dto.BoardDTO;
import com.blacksw.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/board")
	public void writeBoard(@RequestBody BoardDTO.RequestWrite requestWrite) {
		logger.info("writeBoard 진입");
		boardService.insertBoard(requestWrite);
		logger.info("writeBoard 완료");
	}
	
	@PutMapping("/board/{boardId}")
	public void updateBoard(@PathVariable("boardId") int boardId, @RequestBody BoardDTO.RequestUpdate requestUpdate) {
		logger.info("updateBoard 진입");
		boardService.updateBoard(requestUpdate);
		logger.info("updateBoard 완료");
	}
	
	@DeleteMapping("/board/{boardId}")
	public void deleteBoard(@PathVariable("boardId") int boardId, @RequestBody BoardDTO.RequestDelete requestDelete) {
		logger.info("deleteBoard 진입");
		boardService.deleteBoard(requestDelete);
		logger.info("deleteBoard 완료");
	}
	
}
