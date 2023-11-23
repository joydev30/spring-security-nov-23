package com.authenticatedBackend.services;

import com.authenticatedBackend.model.User;
//import com.authenticatedBackend.model.LoginResponseDTO;
import com.authenticatedBackend.model.Role;
import com.authenticatedBackend.repository.RoleRepository;
import com.authenticatedBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private TokenService tokenService;

    public User registerUser(String username, String password){

        System.out.println("Inside register user");

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new User(0, username, encodedPassword, authorities));
    }

//    public LoginResponseDTO loginUser(String username, String password){
//
//        try{
//            Authentication auth = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//            );
//
//            String token = tokenService.generateJwt(auth);
//
//            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);
//
//        } catch(AuthenticationException e){
//            return new LoginResponseDTO(null, "");
//        }
//    }

}
