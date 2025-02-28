package com.example.BookStore.Controller;

import com.example.BookStore.Services.AuthenticationService;
import com.example.BookStore.auth.AuthenticationRequest;
import com.example.BookStore.auth.AuthenticationResponse;
import com.example.BookStore.auth.RegisterRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate/form")
    public String authenticateForm(@ModelAttribute AuthenticationRequest request, HttpSession session) {
        AuthenticationResponse response = service.authenticate(request);
        if (response != null) {
            session.setAttribute("message", "Login successful!");
            return "redirect:/homepage";
        } else {
            session.setAttribute("error", "Invalid email or password!");
            return "redirect:/login";
        }
    }

    @PostMapping("/authenticate/api")
    public ResponseEntity<AuthenticationResponse> authenticateApi(@ModelAttribute AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
