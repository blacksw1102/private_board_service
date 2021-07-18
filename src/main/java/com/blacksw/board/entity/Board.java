package com.blacksw.board.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.blacksw.board.dto.BoardDTO;
import com.blacksw.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "board")
@ToString
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;
	@Column(name = "modified_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date modifiedAt;
	private int views;
	private String uid;
	@ManyToOne
	@JoinColumn(name = "uid", insertable=false, updatable=false)
	private User user;
	
	public BoardDTO.ResponseDetail toResponseDetail() {
		return BoardDTO.ResponseDetail.builder()
				.id(id)
				.title(title)
				.content(content)
				.createdAt(createdAt)
				.views(views)
				.userName(user.getName())
				.build();
	}
	
}
