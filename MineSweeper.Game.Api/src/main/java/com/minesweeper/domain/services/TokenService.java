package com.minesweeper.domain.services;

import com.minesweeper.domain.entity.User;
import com.minesweeper.domain.interfaces.ITokenService;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Slf4j
@Service
public class TokenService implements ITokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	@Override
	public String generateToken(Authentication authentication) {
    User logged = (User) authentication.getPrincipal();
		Date currentDate = new Date();
		Date expirationDate = new Date(currentDate.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("MineSweeper.Game.Api")
				.setSubject(logged.getId().toString())
				.setIssuedAt(currentDate)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	@Override
	public boolean isValidToken(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Long getUserId(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
