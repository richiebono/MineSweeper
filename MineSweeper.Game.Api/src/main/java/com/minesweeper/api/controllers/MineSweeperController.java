package com.minesweeper.api.controllers;

import com.minesweeper.application.models.BoardRequestViewModel;
import com.minesweeper.domain.enums.EMarkType;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minesweeper.domain.exception.MinesweeperException;
import com.minesweeper.domain.enums.EPlayRequest;
import com.minesweeper.application.interfaces.IMineSweeperAppService;

@RestController
@RequestMapping("/minesweeper/v1")
@Validated
@Slf4j
public class MineSweeperController {

	@Autowired
	private IMineSweeperAppService mineSweeperAppService;

	public MineSweeperController(
			IMineSweeperAppService mineSweeperAppService) {
		this.mineSweeperAppService = mineSweeperAppService;
	}

	@PostMapping(value="/game", consumes = "application/json")
	public ResponseEntity newGame(@Valid @RequestBody BoardRequestViewModel request) {
		try {
			if (request.getMines() > request.getColumns() * request.getRows()) {
				return ResponseEntity.badRequest().body("to many mines");
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(mineSweeperAppService.createGame(request));
		} catch (MinesweeperException e) {
			log.error("[Minesweeper] Failed to create a new game exception={}", e);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PostMapping(value = "/game/{userName}",  consumes = "application/json")
	public ResponseEntity playGame(@Valid @RequestBody EPlayRequest request, @PathVariable String userName) {
		try {
			// Get user name in the url path
			// Call the service in order to execute the movement with row, column to that game.
			return ResponseEntity.ok(mineSweeperAppService.play(userName, request));
		} catch (MinesweeperException e) {
			log.error("[Minesweeper Failed to execute movement to play for username={}, exception={}", userName, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping(value="/game/{userName}")
	public ResponseEntity getGame(@PathVariable String userName) {
		try {
			// Get a stores board game for an user.
			return ResponseEntity.ok(mineSweeperAppService.getGame(userName));
		} catch (MinesweeperException e) {
			log.error("[Minesweeper] Failed to get a persisted board game for username={}, exception={}", userName, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@GetMapping(value="/games/{userName}")
	public ResponseEntity getGames(@RequestParam @PathVariable String userName, @RequestParam(required = false) Pageable pageable) {
		try {
			// Get a stores board game for an user.
			return ResponseEntity.ok(mineSweeperAppService.getGames(userName, pageable));
		} catch (MinesweeperException e) {
			log.error("[Minesweeper] Failed to get a persisted board game for username={}, exception={}", userName, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PutMapping(value = "/game/{userName}/flag", consumes = "application/json")
	public ResponseEntity redFlag(@Valid @RequestBody EPlayRequest request, @PathVariable String userName) {
		try {
			// Get user name in the url path
			// Call the service in order to set the flag in row and column in the user's game.
			return ResponseEntity.ok(mineSweeperAppService.mark(userName, request, EMarkType.REDFLAG));
		} catch (MinesweeperException e) {
			log.error("[Minesweeper] Failed to set a red flag in row={}, column={} for username={}, exception={}", request.getRow(),
					request.getColumn(), userName, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping(value = "/game/{userName}/question",  consumes = "application/json")
	public ResponseEntity questionMark(@Valid @RequestBody EPlayRequest request, @PathVariable String userName) {
		try {
			// Get user name in the url path
			// Call the service in order to set the question symbol in row and column in the user's game.
			return ResponseEntity.ok(mineSweeperAppService.mark(userName, request, EMarkType.QUESTION));
		} catch (MinesweeperException e) {
			log.error("[Minesweeper] Failed to set a question symbol in row={}, column={} for username={}, exception={}", request.getRow(),
					request.getColumn(), userName, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
