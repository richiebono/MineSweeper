package com.minesweeper.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameBean {
	private String name;
	private GameStates state;
	private Cell[][] mines;
	private boolean redFlag;
	private boolean questionMark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isRedFlag() {
		return redFlag;
	}

	public void setRedFlag(boolean redFlag) {
		this.redFlag = redFlag;
	}

	public boolean isQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(boolean questionMark) {
		this.questionMark = questionMark;
	}
}
