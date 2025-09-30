package com.tukaram.quizapp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

	@Value("${app.jwt.secret:}")
	private String secret;

	@Value("${app.jwt.expiration-ms:86400000}") // default 1 day
	private long jwtExpirationMs;

	public String generateToken(String email, String role) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("role", role);
		return buildToken(claims, email);
	}

	public boolean validateToken(String token, String expectedEmail) {
		String username = getUsernameFromToken(token);
		return username != null && username.equalsIgnoreCase(expectedEmail) && !isTokenExpired(token);
	}

	public String getUsernameFromToken(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}

	public String getRoleFromToken(String token) {
		Object role = getAllClaimsFromToken(token).get("role");
		return role != null ? role.toString() : null;
	}

	private String buildToken(Map<String, Object> claims, String subject) {
		Date now = new Date();
		Date expiry = new Date(now.getTime() + jwtExpirationMs);
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(now)
				.setExpiration(expiry)
				.signWith(getSigningKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	private boolean isTokenExpired(String token) {
		Date expiration = getAllClaimsFromToken(token).getExpiration();
		return expiration.before(new Date());
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	private Key getSigningKey() {
		if (secret == null || secret.isBlank()) {
			throw new IllegalStateException("Missing JWT secret. Configure 'app.jwt.secret' (Base64-encoded 256-bit key).");
		}
		try {
			byte[] keyBytes = Decoders.BASE64.decode(secret);
			return Keys.hmacShaKeyFor(keyBytes);
		} catch (Exception ex) {
			throw new IllegalStateException("Invalid JWT secret. Provide Base64-encoded 256-bit key in 'app.jwt.secret'.", ex);
		}
	}
}
