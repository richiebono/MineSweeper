package com.minesweeper.application.models;


import com.minesweeper.domain.enums.EGameStates;

public class GameViewModel {

	private long id;
	private String userName;
	private EGameStates state;
	private CellViewModel[][] mines;
	private Boolean redFlag;
	private Boolean questionMark;

	public GameViewModel(CellViewModel[][] mines, String userName) {
		this.mines = mines;
		this.userName = userName;
		this.state = EGameStates.ACTIVE;
		this.redFlag = false;
		this.questionMark = false;
	}
}
