package com.login.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.login.domain.entity.User;
import com.login.login.domain.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User data) {
        User responseSave = this.userService.saveUser(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User data) {
        User responseUpdate = this.userService.updateUser(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(responseUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        this.userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User responseById = this.userService.searchUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseById);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> responseUsers = this.userService.searchUsers();
        return ResponseEntity.status(HttpStatus.OK).body(responseUsers);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User responseByEmail = this.userService.searchUserByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(responseByEmail);
    }
}
