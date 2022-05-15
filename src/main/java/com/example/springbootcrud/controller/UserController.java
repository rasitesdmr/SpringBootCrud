package com.example.springbootcrud.controller;

import com.example.springbootcrud.entity.User;
import com.example.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser = userService.saveUser(user);
        return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.findAllUser();
        return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserId(@PathVariable("id") Long id){
        User userById = userService.getUserById(id);
        return new ResponseEntity<User>(userById,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user){
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<User>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
