package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.User;
import edu.uth.childvaccinesystem.reponsitories.UserReponsitory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserReponsitory userReponsitory;

    public UserService(UserReponsitory userRepository) {
        this.userReponsitory = userRepository;
    }

    public List<User> getAllUsers() {
        return userReponsitory.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userReponsitory.findById(id);
    }

    public User createUser(User user) {
        return userReponsitory.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> userOptional = userReponsitory.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userReponsitory.save(user);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    public void deleteUser(Long id) {
        userReponsitory.deleteById(id);
    }
}