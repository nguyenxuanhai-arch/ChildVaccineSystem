package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.User;
import edu.uth.childvaccinesystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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
}