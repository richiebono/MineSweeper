package com.minesweeper.application.services;

import com.minesweeper.application.interfaces.IMineSweeperAppService;
import com.minesweeper.application.models.BoardRequestViewModel;
import com.minesweeper.application.models.GameBeanViewModel;
import com.minesweeper.domain.interfaces.IMineSweeperService;
import com.minesweeper.domain.entity.Game;
import com.minesweeper.domain.exception.MinesweeperException;
import com.minesweeper.infrastructure.helper.MinesweeperHelper;
import com.minesweeper.domain.entity.GameBean;
import com.minesweeper.domain.enums.EGameStates;
import com.minesweeper.domain.enums.EMarkType;
import com.minesweeper.infrastructure.repository.GameRepository;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minesweeper.domain.entity.BoardRequest;
import com.minesweeper.domain.entity.Cell;
import com.minesweeper.domain.enums.EPlayRequest;

@Slf4j
public class MineSweeperAppService implements IMineSweeperAppService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IMineSweeperService mineSweeperService;

	@Override
	public GameBeanViewModel createGame(BoardRequestViewModel boardRequestViewModel) {
		BoardRequest boardRequest = modelMapper.map(boardRequestViewModel, BoardRequest.class);
		return modelMapper.map(mineSweeperService.createGame(boardRequest), GameBeanViewModel.class);
	}

	@Override
	public GameBeanViewModel getGame(String username) {
		return modelMapper.map(mineSweeperService.getGame(username), GameBeanViewModel.class);
	}

	@Override
	public GameBeanViewModel play(String username, EPlayRequest request)
	{
		return modelMapper.map(mineSweeperService.play(username, request), GameBeanViewModel.class);
	}

	@Override
	public GameBeanViewModel mark(String username, EPlayRequest request, EMarkType markType) {
		return modelMapper.map(mineSweeperService.mark(username, request, markType), GameBeanViewModel.class);
	}
}
