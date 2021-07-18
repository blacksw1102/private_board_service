package com.blacksw.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blacksw.board.controller.BoardController;
import com.blacksw.board.dto.BoardDTO;
import com.blacksw.board.entity.Board;
import com.blacksw.board.repository.BoardRepository;
import com.blacksw.dao.CommonDao;

@Service
public class BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardRepository repository;
	@Autowired
	private CommonDao commonDao;
	
	public void insertBoard(BoardDTO.RequestWrite requestWrite) {
		logger.info("insertBoard 진입");
		logger.info(String.valueOf(requestWrite));
		Board board = requestWrite.toEntity();
		repository.save(board);
		logger.info("insertBoard 완료");
	}
	
}
