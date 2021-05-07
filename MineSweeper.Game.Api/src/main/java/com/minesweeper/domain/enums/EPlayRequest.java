package com.minesweeper.domain.enums;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EPlayRequest {
	@NotNull
	private int column;

	@NotNull
	private int row;
}
