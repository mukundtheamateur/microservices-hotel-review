package com.cts.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.user.entities.User;
import com.cts.user.exceptions.AlreadyExistsException;
import com.cts.user.repositories.UserRepository;
import com.cts.user.security.JwtUtil;
import com.cts.user.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository usersDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user,HttpServletResponse res) {
    	Boolean isExists = usersDao.existsByEmail(user.getEmail());
    	
        if (isExists) {
            throw new AlreadyExistsException("User Already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userService.saveUser(user);
        UserDetails userDetail= userDetailsService.loadUserByUsername(user.getEmail());
        String jwt = jwtUtil.generateToken(userDetail);
        Cookie jwtCookie = new Cookie("jwt", jwt);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setMaxAge(3600);
        jwtCookie.setPath("/");
        jwtCookie.setSecure(true);
        res.addCookie(jwtCookie);
        
        return ResponseEntity.ok(user);
    }
}
