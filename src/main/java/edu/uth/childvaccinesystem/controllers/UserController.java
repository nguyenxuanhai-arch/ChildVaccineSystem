package edu.uth.childvaccinesystem.controllers;

import org.springframework.web.bind.annotation.*;
import edu.uth.childvaccinesystem.models.User;
import edu.uth.childvaccinesystem.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestParam String username, @RequestParam String password, @RequestParam List<String> permissions) {
        return userService.registerUser(username, password, permissions);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam List<String> permissions) {
        return userService.updateUser(id, username, password, permissions);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam List<String> permissions) {
        userService.registerUser(username, password, permissions);
        return "User registered successfully";
    }
}
