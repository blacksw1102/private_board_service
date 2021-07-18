package com.blacksw.board.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blacksw.board.controller.BoardController;
import com.blacksw.board.dto.BoardDTO;
import com.blacksw.board.dto.BoardDTO.RequestUpdate;
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

	public void updateBoard(RequestUpdate requestUpdate) {
		logger.info("updateBoard 진입");
		logger.info(String.valueOf(requestUpdate));
		Optional<Board> oldBoard = repository.findByIdAndUid(requestUpdate.getId(), requestUpdate.getUid());
		oldBoard.ifPresent(selectBoard -> {
			selectBoard.setTitle(requestUpdate.getTitle());
			selectBoard.setContent(requestUpdate.getContent());
			selectBoard.setModifiedAt(new Date(System.currentTimeMillis()));
			repository.save(selectBoard);
		});
		logger.info("updateBoard 완료");
	}
	
}
