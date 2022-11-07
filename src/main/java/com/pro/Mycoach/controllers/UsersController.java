package com.pro.Mycoach.controllers;

import com.pro.Mycoach.data.entities.Users;
import com.pro.Mycoach.secutity.JwtHelper;
import com.pro.Mycoach.services.UsersService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/users")
    public boolean createUser(@RequestBody Users dto) {
        if (!check(dto))
            return false;

        usersService.createUser(dto.getUsername(), dto.getPassword(), dto.getName(), dto.getDescription(), dto.getEmailAddress());
        return true;
    }

    @PostMapping("/{userId}")
    public Users update(@PathVariable("userId") long userId, @RequestBody Users dto){
        if (userId < 1)
            throw new RuntimeException();

        usersService.update(userId, dto.getPassword(), dto.getNewPassword(), dto.getName(), dto.getDescription(), dto.getEmailAddress());

        return new Users(dto.getUsername(), null, dto.getName(), dto.getDescription(), dto.getEmailAddress());
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody Users dto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        return JwtHelper.generateToken(authentication);
    }

    private boolean check(Users dto) {
        return (dto.getUsername() != null && dto.getPassword() != null && dto.getName() != null
        && dto.getDescription() != null && dto.getEmailAddress() != null);
    }
}
