package com.minesweeper.application.interfaces;

import com.minesweeper.application.models.BoardRequestViewModel;
import com.minesweeper.application.models.GameBeanViewModel;
import com.minesweeper.domain.enums.EMarkType;
import com.minesweeper.domain.enums.EPlayRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMineSweeperAppService {

  GameBeanViewModel createGame(BoardRequestViewModel boardRequestViewModel);

  GameBeanViewModel getGame(String username);

  Page<GameBeanViewModel> getGames(String username, Pageable pageable);

  GameBeanViewModel play(String username, EPlayRequest request);

  GameBeanViewModel mark(String username, EPlayRequest request, EMarkType EMarkType);
}
