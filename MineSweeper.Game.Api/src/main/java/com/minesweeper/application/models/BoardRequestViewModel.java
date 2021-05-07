package com.minesweeper.application.models;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestViewModel implements Serializable
{
	private String name;
	private int columns;
	private int rows;
	private int mines;

  public BoardRequestViewModel(String name, int columns, int rows, int mines) {
    this.name = name;
    this.columns = columns;
    this.rows = rows;
    this.mines = mines;
  }
}
