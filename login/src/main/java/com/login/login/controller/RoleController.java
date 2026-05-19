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

import com.login.login.domain.entity.Role;
import com.login.login.domain.service.RoleService;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    
    @Autowired
    RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role data) {
        Role responseSave = this.roleService.saveRole(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable String id, @RequestBody Role data) {
        Role responseUpdate = this.roleService.updateRole(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(responseUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable String id) {
        this.roleService.deleteRoleById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable String id) {
        Role responseById = this.roleService.searchRoleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseById);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        List<Role> responseRoles = this.roleService.searchRoles();
        return ResponseEntity.status(HttpStatus.OK).body(responseRoles);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable String name) {
        Role responseByName = this.roleService.searchRoleByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(responseByName);
    }
}
