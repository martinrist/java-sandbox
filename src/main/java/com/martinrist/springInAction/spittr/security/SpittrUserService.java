package com.martinrist.springInAction.spittr.security;

import com.martinrist.springInAction.spittr.data.SpitterRepository;
import com.martinrist.springInAction.spittr.domain.Spitter;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SpittrUserService implements UserDetailsService {

    private final SpitterRepository repository;

    public SpittrUserService(SpitterRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Spitter spitter;
        try {
            spitter = repository.findByUserName(username);
        } catch (DataAccessException dae) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }

        if (spitter != null) {

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            return new User(spitter.getUsername(), spitter.getPassword(), authorities);
        }

        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
