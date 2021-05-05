package com.minesweeper.application.service.interfaces;

import com.minesweeper.application.model.GameBean;
import com.minesweeper.application.model.BoardRequest;
import com.minesweeper.application.model.MarkType;
import com.minesweeper.application.model.PlayRequest;

public interface MineSweeperService {

	/**
	 * Given a user name, count of rows, count of columns and count mines,
	 * will be create a new minesweeper game.
	 *
	 * @param boardRequest username, rows, columns, mines
	 * @return board
	 */
	GameBean createGame(BoardRequest boardRequest);

	/**
	 * Obtain a board for a username persisted.
	 *
	 * @param username
	 * @return
	 */
	GameBean getGame(String username);

	/**
	 * Execute the play of the user.
	 *
	 * @param username
	 * @param request row and column to be discovered
	 * @return board
	 */
	GameBean play(String username, PlayRequest request);

	/**
	 * Given a row and column mark a cell with a question symbol or a red flag.
	 *
	 * @param userName
	 * @param request
	 * @return
	 */
	GameBean mark(String userName, PlayRequest request, MarkType markType);
}
