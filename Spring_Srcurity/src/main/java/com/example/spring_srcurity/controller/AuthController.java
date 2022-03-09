package com.example.spring_srcurity.controller;

import com.example.spring_srcurity.model.JwtResponse;
import com.example.spring_srcurity.model.Role;
import com.example.spring_srcurity.model.User;
import com.example.spring_srcurity.service.JwtService;
import com.example.spring_srcurity.service.role.IRoleService;
import com.example.spring_srcurity.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getFullName(), userDetails.getAuthorities()));
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Optional<Role>> roleById(@RequestParam("id") Long id) {
        Optional<Role> roles = roleService.findById(id);
        return ResponseEntity.ok(roles);
    }

//    @PostMapping("/saveAcc")
//    private ResponseEntity<?> saveAcc(@RequestBody User user){
//
//    }
}
