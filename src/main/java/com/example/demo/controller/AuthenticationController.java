package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Security.JwtProvider;
import com.example.demo.Security.UserPrincipal;
import com.example.demo.Services.PersonneService;
import com.example.demo.model.Personne;
import com.example.demo.repositry.PersonneRep;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private PersonneService personneService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	private PersonneRep Personnerep;
	
	@GetMapping("/login")
	@ResponseBody
	public ResponseEntity Login( @RequestParam("email") String email, @RequestParam("pass")  String pass) throws Exception{
		
		System.out.print(email);
		authenticate(email,pass);
		Personne personne=personneService.getPersonneByEmail(email);
		UserPrincipal principal=new UserPrincipal(personne);
		personne.setToken(jwtProvider.generateToken(principal));
		return ResponseEntity.ok(personne);
	}
	
	@GetMapping("/get/{email}")
	@ResponseBody
	
	public Personne getEmail(@PathVariable("email") String email) {
		return personneService.getPersonneByEmail(email);
	}

	private void authenticate(String email, String pass) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, pass));
				
		}
		catch (DisabledException ex) {
			throw new Exception("Personne disabled");
		}
		catch (BadCredentialsException ex) {
			System.out.print(pass);
			throw new Exception("bad creadentials");
		}catch (Exception e) {
			
		}
		
	}
	@PostMapping("/Personne")
	public Personne createPrsonne(@RequestBody Personne personne) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		personne.setMot_de_pasee(encoder.encode(personne.getMot_de_pasee()));
		personne.setEnabled(true);
		return Personnerep.save(personne);
	
	


}}
