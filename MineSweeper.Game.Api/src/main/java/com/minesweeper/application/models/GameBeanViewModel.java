package com.minesweeper.application.models;

import com.minesweeper.domain.enums.EGameStates;
import java.io.Serializable;

public class GameBeanViewModel implements Serializable
{
	private String name;
	private EGameStates state;
	private CellViewModel[][] mines;
	private boolean redFlag;
	private boolean questionMark;

	public GameBeanViewModel(String name, EGameStates state,
			CellViewModel[][] mines, boolean redFlag, boolean questionMark) {
		this.name = name;
		this.state = state;
		this.mines = mines;
		this.redFlag = redFlag;
		this.questionMark = questionMark;
	}
}
