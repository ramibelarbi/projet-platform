package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Personne;
import com.example.demo.repositry.PersonneRep;

@Service
public class PersonneService implements UserDetailsService
{
	@Autowired 
	PersonneRep personneRep;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Personne personne=personneRep.findByEmail(email);
		if(personne == null) {
			System.out.print("personne not found");
			throw new  UsernameNotFoundException("personne not found in database");
		}
		else {
			Collection<SimpleGrantedAuthority> authorites=new ArrayList<>();
			authorites.add(new SimpleGrantedAuthority(personne.getRole()));
			return new org.springframework.security.core.userdetails.User(personne.getEmail(), personne.getMot_de_pasee(), authorites);
		}
		
		
	}
	
	
	public Personne getPersonneByEmail(String email) {
		
		return personneRep.findByEmail(email);
	}
	

}
