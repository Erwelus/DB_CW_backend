package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.transfer.RefreshDto;
import com.example.db_cw_backend.model.User;
import com.example.db_cw_backend.security.JwtProvider;
import com.example.db_cw_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/refresh/")
public class RefreshController {
    private final JwtProvider jwtProvider;
    private final UserService userService;

    public RefreshController(JwtProvider jwtProvider, UserService userService){
        this.jwtProvider=jwtProvider;
        this.userService=userService;
    }

    @PostMapping("/token")
    public ResponseEntity refreshToken(@RequestBody RefreshDto refreshDto){
        String username = new String(Base64.getDecoder().decode(refreshDto.getRefresh_token())).split("&")[1];
        User user = userService.findByUsername(username);
        Map<Object, Object> response = new HashMap<>();

        if(user == null) throw new UsernameNotFoundException("User with username " + username + " not found");

        if(user.getRefreshToken().equals(refreshDto.getRefresh_token())) {
            String token = jwtProvider.createToken(username);
            Authentication authentication = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            response.put("username", username);
            response.put("refresh_token", user.getRefreshToken());
            response.put("token", token);
        }else throw new BadCredentialsException("Invalid refresh token");

        return ResponseEntity.ok(response);
    }
}
