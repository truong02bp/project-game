package com.game.presentation.controller;

import com.game.MyUserDetails;
import com.game.common.SecurityConstants;
import com.game.common.utils.JwtUtil;
import com.game.common.utils.SecurityUtils;
import com.game.data.AuthenticateResponse;
import com.game.data.dto.UserDto;
import com.game.service.MyUserDetailsService;
import com.game.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @GetMapping("/user")
    public ResponseEntity<?> getUser(){
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(user.getUser());
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody UserDto userDto) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userDto.getUsername(), userDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username", e);
        }
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(userDto.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(SecurityConstants.JWT_TOKEN_PREFIX+jwt));
    }
}
