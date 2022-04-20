package com.example.demo.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.Services.PersonneService;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter{
	
	//@Value("${jwt.header}")
    private String tokenRequestHeader="Authorization";
	
	//@Value("${jwt.prefix}")
    private String tokenRequestPrefix="Bearer";
   
    @Autowired
    JwtProvider jwtTokenProvider;
    
    
    @Autowired
    private PersonneService personneService;
	
	
    
	public CustomAuthenticationFilter() {
		
		// TODO Auto-generated constructor stub
	}





	
	
	
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token=getTokenFromRequest(request);
		
		if((StringUtils.isNotBlank(token) && jwtTokenProvider.isTokenValid(token))) {

			String email=jwtTokenProvider.getSubjectFromToken(token);
			
			UserPrincipal principal=new UserPrincipal(personneService.getPersonneByEmail(email));
			
			
			
			UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(email,null,principal.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		
		}
		
		filterChain.doFilter(request, response);
		}
	
	
	private String getTokenFromRequest(HttpServletRequest request) {
		String bearerToken="";
		
		try {
		 bearerToken=request.getHeader(tokenRequestHeader);
		
		
		if((StringUtils.isNotBlank(bearerToken)) && bearerToken.startsWith(tokenRequestPrefix)) {
			bearerToken=bearerToken.replace(tokenRequestPrefix, "");
			return bearerToken;
		}
		
		}catch (NullPointerException ex) {
			
			System.out.print(ex.getCause());
			// TODO: handle exception
		}
		return null;
	}

}
