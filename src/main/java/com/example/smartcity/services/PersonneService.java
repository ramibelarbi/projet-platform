package com.example.smartcity.services;

import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Personne;
import com.example.smartcity.repos.AdresseRepo;
import com.example.smartcity.repos.PersonneRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @AllArgsConstructor
public class PersonneService implements UserDetailsService {

    private final PersonneRepo personneRepo;
    private final AdresseRepo adresseRepo;
    private final PasswordEncoder passwordEncoder;
    //@Autowired removed and constructor removed bring back if a problem happens


    @Override
    public UserDetails loadUserByUsername(String cin) throws UsernameNotFoundException {
        Personne user = personneRepo.findPersonneByCin(cin);
        if(user ==null){
            throw new UsernameNotFoundException("Ce Cin n'existe pas!");
        }
        Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new User(user.getCin(),user.getPassword(),authorities);
    }

    public Personne getPersonneByCin(String cin){
        return personneRepo.findPersonneByCin(cin);
    }

    public Personne addPersonne(Personne personne){
        adresseRepo.save(personne.getAdresse());
        personne.setPassword(passwordEncoder.encode(personne.getPassword()));
        return personneRepo.save(personne);
    }
    public List<Personne> getAllPersonnes(){
        return personneRepo.findAll();
    }
    public Personne getPersonneById(Long id){
        return personneRepo.findPersonneById(id).orElseThrow(()-> new NotFoundException("La Personne avec le Id: "+id +"n'a pas ete trouvee!"));
    }
    public Personne updatePersonne(Personne personne){
        adresseRepo.save(personne.getAdresse());
        personne.setPassword(passwordEncoder.encode(personne.getPassword()));
        return personneRepo.save(personne);
    }
    @Transactional
    public void deletePersonne(Long id){
        adresseRepo.delete(personneRepo.findPersonneById(id).get().getAdresse());
        personneRepo.deletePersonneById(id);
    }


}
