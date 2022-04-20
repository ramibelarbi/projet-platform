package com.example.demo.Security;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtProvider {
	
	
	private String secret="secret";
	

	private long expirationDate=800000;
	
	
	
	
	

	
	public String generateToken(UserPrincipal userPrincipal) {
		
		Algorithm algorithm=Algorithm.HMAC256(secret.getBytes());
		String[] claims=getAuthoritiesFromUser(userPrincipal);
		return JWT.create().withIssuer("Smart_ADMIN")
				.withIssuedAt(Date.from(Instant.now()))
				
				.withSubject(userPrincipal.getUsername())
				.withArrayClaim("Authorities", claims)
				.withExpiresAt(new Date(System.currentTimeMillis()+expirationDate))
				.sign(algorithm);
		
				
		
	}
	
	
	public String[] getAuthoritiesFromUser(UserPrincipal user) {
		List<String> authorities=new ArrayList<>();
		for(GrantedAuthority grantedAuthority :user.getAuthorities())
			authorities.add(grantedAuthority.getAuthority());
		return authorities.toArray(new String[0]);
	}
	
	private JWTVerifier getVerifier() {
		try {
			Algorithm algorithm=Algorithm.HMAC256(secret);
			JWTVerifier verifier=JWT.require(algorithm).withIssuer("Smart_ADMIN").build();
			return verifier;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	
	
	public String[] getAuthoritiesFromToken(String token) {
		
		JWTVerifier verifier=getVerifier();
		return verifier.verify(token).getClaim("Authorities").asArray(String.class);
			
	}
	public String getSubjectFromToken(String token) {
		if(isTokenValid(token)) {
		Claims claims = Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token)
                .getBody();
		return claims.getSubject();
		}
		return null;
		
	}
	
	public boolean isTokenValid(String token) {
		try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);

        } catch (SignatureException ex) {
            
        	

        } catch (MalformedJwtException
        		ex) {
        	

        } catch (ExpiredJwtException ex) {
        	
        	

        } catch (IllegalArgumentException ex) {
        	
        }
		
        
        return true;
    }

}
