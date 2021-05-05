package com.minesweeper.application.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell implements Serializable {

	private boolean revealed;
	private int minesAround;
	private boolean mine;
	private boolean redFlag;
	private boolean questionMark;

	public Cell(boolean mine) {
		this.mine = mine;
	}

	public boolean isRevealed() {
		return revealed;
	}

	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}

	public int getMinesAround() {
		return minesAround;
	}

	public void setMinesAround(int minesAround) {
		this.minesAround = minesAround;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public boolean isQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(boolean questionMark) {
		this.questionMark = questionMark;
	}

	public boolean isRedFlag() {
		return redFlag;
	}

	public void setRedFlag(boolean redFlag) {
		this.redFlag = redFlag;
	}
}
