package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.User;
import edu.uth.childvaccinesystem.models.Permission;
import edu.uth.childvaccinesystem.repositories.UserRepository;
import edu.uth.childvaccinesystem.repositories.PermissionRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection
    public UserService(UserRepository userRepository, PermissionRepository permissionRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Tạo User mới với danh sách quyền
     */
    public User registerUser(String username, String password, List<String> permissionCodes) {
        Set<Permission> permissions = permissionCodes.stream()
                .map(code -> permissionRepository.findByCode(code)
                        .orElseThrow(() -> new RuntimeException("Permission not found: " + code)))
                .collect(Collectors.toSet());

        User user = new User(username, passwordEncoder.encode(password));
        user.setPermissions(permissions);
        return userRepository.save(user);
    }

    /**
     * Cập nhật thông tin User
     */
    public User updateUser(Long id, String username, String password, List<String> permissionCodes) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        Set<Permission> permissions = permissionCodes.stream()
                .map(code -> permissionRepository.findByCode(code)
                        .orElseThrow(() -> new RuntimeException("Permission not found: " + code)))
                .collect(Collectors.toSet());
        user.setPermissions(permissions);

        return userRepository.save(user);
    }

    /**
     * Xóa User
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Lấy danh sách tất cả Users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Load User từ Database để xác thực đăng nhập
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getPermissions().stream()
                        .map(Permission::getCode)
                        .toArray(String[]::new))
                .build();
    }
}
