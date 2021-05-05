package com.minesweeper.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minesweeper.domain.entity.Game;
import com.minesweeper.application.model.GameStates;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	Optional<Game> findByUserNameAndState(String userName, GameStates State);

}
