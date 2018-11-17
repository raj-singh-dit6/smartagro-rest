package gov.smartagro.api.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.smartagro.api.exception.AppException;
import gov.smartagro.api.model.Role;
import gov.smartagro.api.model.RoleName;
import gov.smartagro.api.model.User;
import gov.smartagro.api.payload.JwtAuthenticationResponse;
import gov.smartagro.api.payload.LoginRequest;
import gov.smartagro.api.payload.SignUpRequest;
import gov.smartagro.api.repository.RoleRepository;
import gov.smartagro.api.repository.UserRepository;
import gov.smartagro.api.response.SingleResponse;
import gov.smartagro.api.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public SingleResponse<JwtAuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    	SingleResponse<JwtAuthenticationResponse> resp = new SingleResponse<>();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        resp.setData(new JwtAuthenticationResponse(jwt));
        resp.setSuccess(true);
        return resp;
    }

    @PostMapping("/signup")
    public SingleResponse<String> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
    	SingleResponse<String> resp = new SingleResponse<>();
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
             resp.setData("Username is already taken!");
             resp.setStatusCode(HttpStatus.BAD_REQUEST.toString());
             resp.setSuccess(true);
			return	resp;
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            resp.setData("Email Address already in use!");
            resp.setStatusCode(HttpStatus.BAD_REQUEST.toString());
            resp.setSuccess(true);
			return	resp;
        }

        // Creating user's account
        User user = new User(signUpRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        resp.setData("User registered successfully");
        resp.setStatusCode("200");
        resp.setSuccess(true);
        return resp;
    }
}
