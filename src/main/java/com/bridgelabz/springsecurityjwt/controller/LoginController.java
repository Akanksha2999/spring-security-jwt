package com.bridgelabz.springsecurityjwt.controller;

import com.bridgelabz.springsecurityjwt.entity.AuthenticateRequest;
import com.bridgelabz.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to login page !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(),authenticateRequest.getPassword()));
        }catch (Exception exception){
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authenticateRequest.getUserName());
    }
}
