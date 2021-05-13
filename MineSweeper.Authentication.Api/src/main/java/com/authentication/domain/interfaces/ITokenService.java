package com.authentication.domain.interfaces;

import org.springframework.security.core.Authentication;

public interface ITokenService {


  /**
   * Generate a valid Token
   *
   * @param token
   * @return string
   */
  String generateToken(Authentication authentication);

  /**
   * Check if Token is valid
   *
   * @param token
   * @return boolean
   */
  boolean isValidToken(String token);

  /**
   * Get userId by token
   *
   * @param token
   * @return Long
   */
  Long getUserId(String token);

}
