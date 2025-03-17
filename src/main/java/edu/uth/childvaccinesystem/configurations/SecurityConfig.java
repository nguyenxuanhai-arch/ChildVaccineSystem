package edu.uth.childvaccinesystem.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF cho API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Chỉ ADMIN truy cập trang /admin
                        .requestMatchers("/user/**").hasRole("USER") // Chỉ USER truy cập trang /user
                        .requestMatchers("/", "/login", "/register", "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll() // Cho phép truy cập không cần đăng nhập
                        .anyRequest().authenticated() // Các request khác phải đăng nhập
                )
                .formLogin(form -> form // Sử dụng form login mặc định
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());

        return http.build();
    }
}