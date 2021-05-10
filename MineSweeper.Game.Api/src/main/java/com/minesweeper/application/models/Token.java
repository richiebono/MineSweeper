package com.minesweeper.application.models;

public class Token {

	private String token;
	private String type;

	public Token(String token, String tipo) {
		this.token = token;
		this.type = tipo;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return type;
	}

}
