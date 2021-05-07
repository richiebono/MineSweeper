package com.minesweeper.application;

import com.minesweeper.domain.entity.Game;
import com.minesweeper.domain.exception.MinesweeperException;
import com.minesweeper.domain.entity.BoardRequest;
import com.minesweeper.domain.entity.Cell;
import com.minesweeper.domain.entity.GameBean;
import com.minesweeper.domain.enums.EGameStates;
import com.minesweeper.domain.enums.EMarkType;
import com.minesweeper.domain.enums.EPlayRequest;
import com.minesweeper.domain.interfaces.IMineSweeperService;
import com.minesweeper.infrastructure.repository.GameRepository;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = {IMineSweeperService.class})
public class MineSweeperServiceTest {

	@Autowired
	private IMineSweeperService mineSweeperService;

	@MockBean
	private GameRepository gameRepository;

	@MockBean
	private ModelMapper modelMapper;

	private Game game;
	private BoardRequest request;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		Cell[][] matrix = new Cell[2][2];
		game = Game.builder().id(321L).userName("MinesweeperTest").redFlag(false).mines(matrix).build();

		request = BoardRequest.builder().columns(5).rows(5).mines(5).name("MinesweeperTest").build();
	}

	@Test
	public void testCreateGameSuccessful() {
		BoardRequest request = BoardRequest.builder().columns(5).rows(5).mines(5).name("MinesweeperTest").build();
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.empty());
		when(gameRepository.save(any(Game.class))).thenReturn(game);
		mineSweeperService.createGame(request);

		verify(gameRepository, times(1)).save(any(Game.class));
	}

	@Test(expected = MinesweeperException.class)
	public void testCreateGameNameAlreadyExists() {
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE))
				.thenReturn(Optional.of(new Game()));

		mineSweeperService.createGame(request);
	}

	@Test
	public void testGetGame() {
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.of(game));
		when(modelMapper.map(game, GameBean.class)).thenReturn(GameBean.builder().build());
		assertThat(mineSweeperService.getGame(request.getName())).isNotNull();
	}

	@Test(expected = MinesweeperException.class)
	public void testPlayGameNotFound() {
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.empty());
		mineSweeperService.play(request.getName(), EPlayRequest.builder().column(0).row(0).build());
	}

	@Test(expected = MinesweeperException.class)
	public void testGetGameNotFound() {
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.empty());
		mineSweeperService.getGame(request.getName());
	}

	@Test
	public void testMarkFlag() {
		game.getMines()[0][0] = new Cell();
		game.getMines()[0][0].setRevealed(false);
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.of(game));
		when(gameRepository.save(any(Game.class))).thenReturn(game);
		when(modelMapper.map(game, GameBean.class)).thenReturn(GameBean.builder().build());
		GameBean result = mineSweeperService.mark(request.getName(), EPlayRequest.builder().column(0).row(0).build(), EMarkType.REDFLAG);
		assertThat(result).isNotNull();
	}

	@Test(expected = MinesweeperException.class)
	public void testMarkFlagGameNotFound() {
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.empty());
		mineSweeperService.mark(request.getName(), EPlayRequest.builder().column(0).row(0).build(), EMarkType.QUESTION);
	}

	@Test(expected = MinesweeperException.class)
	public void testMarkFlagGameAlreadyRevealed() {
		game.getMines()[0][0] = new Cell();
		game.getMines()[0][0].setRevealed(true);
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.of(game));
		mineSweeperService.mark(request.getName(), EPlayRequest.builder().column(0).row(0).build(), EMarkType.QUESTION);
	}

	@Test
	public void testPlayWon() {
		game.getMines()[0][0] = new Cell(false);
		game.getMines()[0][1] = new Cell(true);
		game.getMines()[1][0] = new Cell(true);
		game.getMines()[1][1] = new Cell(true);
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.of(game));
		mineSweeperService.play(request.getName(), EPlayRequest.builder().column(0).row(0).build());

		ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
		verify(gameRepository, times(1)).save(captor.capture());
		Assertions.assertThat(captor.getValue().getState()).isEqualTo(EGameStates.WON);
	}

	@Test
	public void testPlayBlowUp() {
		game.getMines()[0][0] = new Cell(true);
		when(gameRepository.findByUserNameAndState(request.getName(), EGameStates.ACTIVE)).thenReturn(Optional.of(game));
		mineSweeperService.play(request.getName(), EPlayRequest.builder().column(0).row(0).build());

		ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
		verify(gameRepository, times(1)).save(captor.capture());
		Assertions.assertThat(captor.getValue().getState()).isEqualTo(EGameStates.BLOWUP);
	}
}

