package com.rest.aurumrh.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dto.User;
import com.rest.aurumrh.service.UserServiceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * @author Samson Effes
 */
@Service
public class JWTService {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Value("${spring.jwt.secret}")
	private String JWT_SECRET;

	@Value("${spring.jwt.jwtExpirationInMs}")
	private int JWT_EXPIRATION_TIME_IN_MILLISECONDS;

	public String generateToken(String userName){
		Map<String, Object> claims = new HashMap<>();

		Optional<User> user = userServiceImpl.getUserByEmail(userName);
		User finallyUser = user.get();

		claims.put("user_id", finallyUser.getId());
		claims.put("role", finallyUser.getRole());

		return tokenCreator(claims, userName);
	}

	public String tokenCreator(Map<String, Object> claims, String userName){
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+JWT_EXPIRATION_TIME_IN_MILLISECONDS))
				.signWith(getSignedKey(), SignatureAlgorithm.HS256).compact();
	}

	public String extractUsernameFromToken(String theToken){
		return extractClaim(theToken, Claims ::getSubject);
	}
	public Date extractExpirationTimeFromToken(String theToken) {
		return extractClaim(theToken, Claims :: getExpiration);
	}

	public Boolean validateToken(String theToken, UserDetails userDetails){
		final String userName = extractUsernameFromToken(theToken);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(theToken));
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSignedKey())
				.build()
				.parseClaimsJws(token)
				.getBody();

	}
	private boolean isTokenExpired(String theToken) {
		return extractExpirationTimeFromToken(theToken).before(new Date());
	}
	private Key getSignedKey(){
		byte[] keyByte = Decoders.BASE64.decode(JWT_SECRET);
		return Keys.hmacShaKeyFor(keyByte);
	}
}