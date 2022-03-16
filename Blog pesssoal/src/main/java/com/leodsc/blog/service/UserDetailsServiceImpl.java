package com.leodsc.blog.service;

import com.leodsc.blog.model.UserModel;
import com.leodsc.blog.repository.UserRepository;
import com.leodsc.blog.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = repo.findByUsername(username);
        return user.map(UserDetailsImpl::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Usuario %s não foi achado.", username)));
    }

    private boolean userExists(String username) {
        return repo.findByUsername(username).isPresent();
    }

    private void encodePassword(UserModel user) {
        String encoded = passwordEncoder().encode(user.getPassword());
        user.setPassword(encoded);
    }

    public ResponseEntity<UserModel> createNewUser(UserModel user) {
        boolean userExists = userExists(user.getUsername());

        if (userExists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
        } else {
            encodePassword(user);
            return ResponseEntity.created(URI.create("/registrar")).body(repo.save(user));
        }
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

}
