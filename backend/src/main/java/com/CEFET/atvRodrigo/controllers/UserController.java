package com.CEFET.atvRodrigo.controllers;

import com.CEFET.atvRodrigo.RecordsDTO.UserRecordDTO;
import com.CEFET.atvRodrigo.models.User;
import com.CEFET.atvRodrigo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    //POST
    @PostMapping(value = "/")
    public ResponseEntity<User> postUser(@RequestBody @Valid UserRecordDTO dto) {
        User user = userService.addUser(dto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //GET ALL
    @GetMapping(value = "/")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id) {
        Optional<User> userOptional = userService.findUserById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found by id: " + id);
        }
    }

    @GetMapping(value = "/name/{id}")
    public ResponseEntity<?> getUserByName(@PathVariable String name){
        List<User> users = userService.findUserByName(name);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //PUT BY ID
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putUser(@PathVariable UUID id,
                                     @RequestBody @Valid UserRecordDTO dto) {
        User user = userService.updateUserById(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    //DELET BY ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        Optional<User> userOptional = userService.findUserById(id);
        if (userOptional.isPresent()) {
            userService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body("User exclued successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found by id: " + id);
        }

    }
}


