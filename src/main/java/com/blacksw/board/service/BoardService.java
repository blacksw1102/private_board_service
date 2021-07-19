package com.blacksw.board.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blacksw.board.controller.BoardController;
import com.blacksw.board.dto.BoardDTO;
import com.blacksw.board.dto.BoardDTO.RequestDelete;
import com.blacksw.board.dto.BoardDTO.RequestDetail;
import com.blacksw.board.dto.BoardDTO.RequestUpdate;
import com.blacksw.board.dto.BoardDTO.ResponseDetail;
import com.blacksw.board.entity.Board;
import com.blacksw.board.repository.BoardRepository;
import com.blacksw.dao.CommonDao;

@Service
public class BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

	@Autowired
	private BoardRepository repository;
	@Autowired
	private CommonDao commonDao;
	
	private BoardDTO.ResponseDetail responseDetail;
	
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
		Board board = repository.findByIdAndUid(requestUpdate.getId(), requestUpdate.getUid()).get();
		board.setTitle(requestUpdate.getTitle());
		board.setContent(requestUpdate.getContent());
		board.setModifiedAt(new Date());
		repository.save(board);
		logger.info("updateBoard 완료");
	}

	public void deleteBoard(RequestDelete requestDelete) {
		logger.info("deleteBoard 진입");
		logger.info(String.valueOf(requestDelete));
		repository.deleteByIdAndUid(requestDelete.getId(), requestDelete.getUid());
		logger.info("deleteBoard 완료");
	}

	public ResponseDetail getBoardDetail(BoardDTO.RequestDetail requestDetail) {
		logger.info("getBoardDetail 진입");
		logger.info(String.valueOf(requestDetail));
		Board board =  repository.findById(requestDetail.getId()).get();
		board.setViews(board.getViews() + 1);
		repository.save(board);
		responseDetail = board.toResponseDetail();
		logger.info("getBoardDetail 완료");
		return responseDetail;
	}
	
}
