package edu.uth.childvaccinesystem.controllers;

import edu.uth.childvaccinesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    // API Đăng ký
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password, "USER");
        return "User registered successfully!";
    }
}

