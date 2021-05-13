package com.authentication.application.services;

import com.authentication.application.interfaces.ITokenAppService;
import com.authentication.domain.interfaces.ITokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

@Slf4j
public class TokenAppService implements ITokenAppService {

  @Autowired
  private ITokenService tokenService;

  @Override
  public String generateToken(Authentication authentication) {
    return tokenService.generateToken(authentication);
  }

  @Override
  public boolean isValidToken(String token) {
    return tokenService.isValidToken(token);
  }

  @Override
  public Long getUserId(String token) {
    return tokenService.getUserId(token);
  }

}
