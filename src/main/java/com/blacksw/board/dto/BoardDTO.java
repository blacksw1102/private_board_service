package com.blacksw.board.dto;

import com.blacksw.board.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class BoardDTO {

	@Setter
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RequestWrite {
		private String title;
		private String content;
		private String uid;
		
		public Board toEntity() {
			return Board.builder()
					.title(title)
					.content(content)
					.uid(uid)
					.build();
		}
	}
	
	@Setter
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RequestUpdate {
		private int id;
		private String title;
		private String content;
		private String uid;
		
		public Board toEntity() {
			return Board.builder()
					.id(id)
					.title(title)
					.content(content)
					.uid(uid)
					.build();
		}
	}
	
	@Setter
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RequestDelete {
		private int id;
		private String uid;
		
		public Board toEntity() {
			return Board.builder()
					.id(id)
					.uid(uid)
					.build();
		}
	}
	
}
