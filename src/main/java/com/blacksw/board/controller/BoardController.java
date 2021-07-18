package com.blacksw.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
