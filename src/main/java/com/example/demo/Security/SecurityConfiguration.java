package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.Services.PersonneService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private  UserDetailsService detailsService;
	
	@Autowired
	private PersonneService personneService;
	
	@Autowired
	CustomAuthenticationFilter AuthenticationFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
	auth.userDetailsService(detailsService).passwordEncoder(getPasswordEncoder());
	
		
		
	
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();	
	}
	
	@Override
	@Bean
	
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().
		authorizeRequests()
		.antMatchers("/Personne/citoyen**").hasAuthority("citoyen")
		.antMatchers("/Personne/admin**").hasAnyAuthority("employer","admin")
		.antMatchers("/auth/**").permitAll()
		.antMatchers("/**").permitAll()
		.anyRequest().authenticated();
		//.and().exceptionHandling().authenticationEntryPoint(getAuthenticationEntryPoint());
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(AuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		
		
		
		}
	

}
