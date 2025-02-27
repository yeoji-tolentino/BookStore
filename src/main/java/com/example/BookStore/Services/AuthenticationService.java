package com.example.BookStore.Services;

import com.example.BookStore.Config.JwtService;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Model.Role;
import com.example.BookStore.Repository.CustomerRepository;
import com.example.BookStore.auth.AuthenticationRequest;
import com.example.BookStore.auth.AuthenticationResponse;
import com.example.BookStore.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        System.out.println("Registering " + request.getEmail());
        var customer = new Customer(request.getUsername(), request.getEmail(), passwordEncoder.encode(request.getPassword()));
        repository.save(customer);
        var jwtToken = jwtService.generateToken(customer);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var customer = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) customer);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
