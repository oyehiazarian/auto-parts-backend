package de.shop.auto_parts.Security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.shop.auto_parts.Security.model.AuthenticationResponse;
import de.shop.auto_parts.Security.model.User;
import de.shop.auto_parts.Security.service.AuthenticationService;

@RestController
public class AuthenticationController {

    private final AuthenticationService authservice;

    public AuthenticationController(AuthenticationService authservice) {
        this.authservice = authservice;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){

        return ResponseEntity.ok(authservice.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request){
        return ResponseEntity.ok(authservice.authenticate(request));
    }
}
