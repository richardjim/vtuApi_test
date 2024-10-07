// AuthenticationService.java
package com.dev.vtu_api.auth.Service;

import com.dev.vtu_api.auth.AuthenticationRequest;
import com.dev.vtu_api.auth.AuthenticationResponse;
import com.dev.vtu_api.auth.RegisterRequest;
import com.dev.vtu_api.config.JwtService;
import com.dev.vtu_api.user.Repositories.UserRepository;
import com.dev.vtu_api.user.Role;
import com.dev.vtu_api.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest request) {
        // Check if user already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        }

        // Build and save user with hashed password
        var user = User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // Hash password
                .role(Role.USER)
                .build();

        // Save the user
        userRepository.save(user);

        // Generate JWT token
        String jwtToken = jwtService.generateToken(user);
        System.out.println("JWT Token on Register: " + jwtToken);  // Debugging line

        // Return AuthenticationResponse
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            // Authenticate user with AuthenticationManager
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        // Find user by email
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // Generate JWT token
        String jwtToken = jwtService.generateToken(user);
        System.out.println("JWT Token on Authenticate: " + jwtToken);  // Debugging line

        // Return AuthenticationResponse
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}   