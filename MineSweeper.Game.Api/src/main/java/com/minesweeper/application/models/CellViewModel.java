package com.minesweeper.application.models;

import java.io.Serializable;

public class CellViewModel implements Serializable {

	private boolean revealed;
	private int minesAround;
	private boolean mine;
	private boolean redFlag;
	private boolean questionMark;

	public CellViewModel(boolean revealed, int minesAround, boolean mine, boolean redFlag,
			boolean questionMark) {
		this.revealed = revealed;
		this.minesAround = minesAround;
		this.mine = mine;
		this.redFlag = redFlag;
		this.questionMark = questionMark;
	}
}
