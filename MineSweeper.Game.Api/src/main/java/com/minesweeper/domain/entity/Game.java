package com.minesweeper.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.minesweeper.domain.enums.EGameStates;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Data
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Games")
public class Game {

	@Id
	@GeneratedValue(generator = "id_generator")
	@SequenceGenerator(
			name = "id_generator",
			sequenceName = "id_generator",
			initialValue = 1000
	)
	private long id;

	@Column
	private String userName;

	@Column
	@Enumerated(EnumType.STRING)
	private EGameStates state;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private Cell[][] mines;

	@Column
	private Boolean redFlag;

	@Column
	private Boolean questionMark;

	public Game(Cell[][] mines, String userName) {
		this.mines = mines;
		this.userName = userName;
		this.state = EGameStates.ACTIVE;
		this.redFlag = false;
		this.questionMark = false;
	}

  public Game(Game game) {
		this.mines = game.mines;
		this.userName = game.userName;
		this.state = game.state;
		this.redFlag = game.redFlag;
		this.questionMark = game.questionMark;
  }
}
