package com.minesweeper.application.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardRequest {
	@NotEmpty
	private String name;

	@NotNull
	@Min(2)
	@Max(50)
	private int columns;

	@NotNull
	@Min(2)
	@Max(50)
	private int rows;

	@NotNull
	@Min(1)
	@Max(2401) // (x-1)(y-1) where x is max columns and y is max rows. (https://en.wikipedia.org/wiki/Microsoft_Minesweeper)
	private int mines;

	public int getMines() {
		return mines;
	}

	public void setMines(int mines) {
		this.mines = mines;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
}
