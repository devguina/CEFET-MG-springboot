package com.CEFET.atvRodrigo.controllers;

import com.CEFET.atvRodrigo.RecordsDTO.UserRecordDTO;
import com.CEFET.atvRodrigo.models.User;
import com.CEFET.atvRodrigo.services.UserService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/post")
    public ResponseEntity<User> postUser(@RequestBody @Valid UserRecordDTO dto){
        User user = userService.addUser(dto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
