package com.minesweeper.application.services;

import com.minesweeper.application.interfaces.IMineSweeperAppService;
import com.minesweeper.application.models.BoardRequestViewModel;
import com.minesweeper.application.models.GameBeanViewModel;
import com.minesweeper.domain.entity.GameBean;
import com.minesweeper.domain.interfaces.IMineSweeperService;
import com.minesweeper.domain.enums.EMarkType;

import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.minesweeper.domain.entity.BoardRequest;
import com.minesweeper.domain.enums.EPlayRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
	public Page<GameBeanViewModel> getGames(String username, Pageable pageable) {
		return mineSweeperService.getGames(username, pageable).map(this::convertToViewModel);
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

	public GameBeanViewModel convertToViewModel(GameBean gameBean) {
		return modelMapper.map(gameBean, GameBeanViewModel.class);
	}

}
