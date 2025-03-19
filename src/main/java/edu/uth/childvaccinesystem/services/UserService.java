package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.User;
import edu.uth.childvaccinesystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public long CreateUser(User user) {
        return this.userRepository.save(user).getId();
    }

    public long UpdateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());

        return userRepository.save(user).getId();
    }

    public long DeleteUser(User user) {
        return this.userRepository.save(user).getId();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(String username, String password, String role) {
        User user = new User(username, passwordEncoder.encode(password), role);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}