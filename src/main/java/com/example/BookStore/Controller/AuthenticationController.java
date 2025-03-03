package com.example.BookStore.Controller;

import com.example.BookStore.Services.AuthenticationService;
import com.example.BookStore.auth.AuthenticationRequest;
import com.example.BookStore.auth.AuthenticationResponse;
import com.example.BookStore.auth.RegisterRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate/form")
    public String authenticateForm(@ModelAttribute AuthenticationRequest request, HttpSession session) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        return "redirect:/homepage";
    }

    @PostMapping("/authenticate/api")
    public ResponseEntity<AuthenticationResponse> authenticateApi(@ModelAttribute AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
