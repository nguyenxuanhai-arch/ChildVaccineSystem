package edu.uth.childvaccinesystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uth.childvaccinesystem.models.User;
import edu.uth.childvaccinesystem.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public long addUser(@RequestBody User user) {
        return userService.CreateUser(user);
    }

    @PutMapping("/user/{id}")
    public long updateUser(@PathVariable Long id,@RequestBody User user) {
        return userService.UpdateUser(id, user);
    }

    @DeleteMapping("/user")
    public long deleteUser(@RequestBody User user) {
        return userService.DeleteUser(user);
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        userService.registerUser(username, password, role);
        return "redirect:/login";
    }
}
