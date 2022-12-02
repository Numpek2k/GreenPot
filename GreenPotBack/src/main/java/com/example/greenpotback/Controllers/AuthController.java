package com.example.greenpotback.Controllers;

import com.example.greenpotback.Dto.AuthTokenDto;
import com.example.greenpotback.Security.SecurityConst;
import com.example.greenpotback.Security.TokenProvider;
import com.example.greenpotback.User.Role.RoleRepository;
import com.example.greenpotback.User.User;
import com.example.greenpotback.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthTokenDto> login(@RequestParam(name = "email") String email,
                                              @RequestParam(name = "password") String password){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = tokenProvider.generateAccessToken(email);
        String refreshToken = tokenProvider.generateRefreshToken(email);
        return new ResponseEntity<>(new AuthTokenDto(accessToken,refreshToken),HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        if(userRepository.existsByEmail(user.getEmail())){
            return new ResponseEntity<>("The given e-mail address is already taken", HttpStatus.OK);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByName("USER"));
        userRepository.save(user);

        return new ResponseEntity<>("User registration successful",HttpStatus.OK);
    }

    @GetMapping("/reftoken")
    public ResponseEntity<AuthTokenDto> refreshToken(HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authHeader != null && authHeader.startsWith(SecurityConst.JWT_TOKEN_TYPE)){
            String refreshToken = authHeader.substring(SecurityConst.JWT_TOKEN_TYPE.length());
            tokenProvider.validateToken(refreshToken);

            String email = tokenProvider.getEmailFromJWT(refreshToken);
            String accessToken = tokenProvider.generateAccessToken(email);

            return new ResponseEntity<>(new AuthTokenDto(accessToken,SecurityConst.JWT_TOKEN_TYPE + refreshToken),HttpStatus.OK);
        }
        else throw new RuntimeException("Refresh token missing");
    }
}
