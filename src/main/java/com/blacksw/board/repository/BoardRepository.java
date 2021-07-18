package com.blacksw.board.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blacksw.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

	Optional<Board> findByIdAndUid(int id, String uid);
	
	@Transactional
	void deleteByIdAndUid(int id, String uid);
	
}
