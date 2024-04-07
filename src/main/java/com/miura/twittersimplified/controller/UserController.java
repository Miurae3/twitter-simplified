package com.miura.twittersimplified.controller;

import com.miura.twittersimplified.dto.CreateUserDto;
import com.miura.twittersimplified.entities.Role;
import com.miura.twittersimplified.entities.User;
import com.miura.twittersimplified.repository.RoleRepository;
import com.miura.twittersimplified.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @PostMapping("/users")

    public ResponseEntity<Void> newUser(@RequestBody CreateUserDto dto){

       var basicRole =  roleRepository.findByName(Role.Values.BASIC.name());

       var userFromDb = userRepository.findByUsername(dto.username());

       if (userFromDb.isPresent()) {
           throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
       }

       var user = new User();

       user.setUsername(dto.username());
       user.setPassword(bCryptPasswordEncoder.encode(dto.password()));
       user.setRoles(Set.of((Role) basicRole));

       userRepository.save(user);

        return ResponseEntity.ok().build();

    }




}
