package com.minesweeper.domain.entity;

import com.minesweeper.domain.enums.EGameStates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameBean {
	private String name;
	private EGameStates state;
	private Cell[][] mines;
	private boolean redFlag;
	private boolean questionMark;
}
