package com.minesweeper.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.minesweeper.application.model.Cell;
import com.minesweeper.application.model.GameStates;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Data
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {

	@Id
	@GeneratedValue(generator = "id_generator")
	@SequenceGenerator(
			name = "id_generator",
			sequenceName = "id_generator",
			initialValue = 1000
	)
	private long id;

	@Column
	private String userName;

	@Column
	@Enumerated(EnumType.STRING)
	private GameStates state;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private Cell[][] mines;

	@Column
	private Boolean redFlag;

	@Column
	private Boolean questionMark;

	public Game(Cell[][] mines, String userName) {
		this.mines = mines;
		this.userName = userName;
		this.state = GameStates.ACTIVE;
		this.redFlag = false;
		this.questionMark = false;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public GameStates getState() {
		return state;
	}

	public void setState(GameStates state) {
		this.state = state;
	}

	public Cell[][] getMines() {
		return mines;
	}

	public void setMines(Cell[][] mines) {
		this.mines = mines;
	}

	public Boolean getRedFlag() {
		return redFlag;
	}

	public void setRedFlag(Boolean redFlag) {
		this.redFlag = redFlag;
	}

	public Boolean getQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(Boolean questionMark) {
		this.questionMark = questionMark;
	}
}
