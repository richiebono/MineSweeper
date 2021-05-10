package com.minesweeper.infrastructure.repository;

import com.minesweeper.domain.entity.Game;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minesweeper.domain.enums.EGameStates;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	Optional<Game> findByUserNameAndState(String userName, EGameStates State);

	Page<Game> findByUserNameAndState(String username, EGameStates active, Pageable Pageable);
}
