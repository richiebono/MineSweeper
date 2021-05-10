package com.minesweeper.application.interfaces;

import org.springframework.security.core.Authentication;

public interface ITokenAppService {

  String generateToken(Authentication authentication);

  boolean isValidToken(String token);

  Long getUserId(String token);

}
