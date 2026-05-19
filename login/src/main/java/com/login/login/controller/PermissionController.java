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

import com.login.login.domain.entity.Permission;
import com.login.login.domain.service.PermissionService;

@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionController {
    
    @Autowired
    PermissionService permissionService;

    @PostMapping
    public ResponseEntity<Permission> savePermission(@RequestBody Permission data) {
        Permission responseSave = this.permissionService.savePermission(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable String id, @RequestBody Permission data) {
        Permission responseUpdate = this.permissionService.updatePermission(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(responseUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable String id) {
        this.permissionService.deletePermissionById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable String id) {
        Permission responseById = this.permissionService.searchPermissionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseById);
    }

    @GetMapping
    public ResponseEntity<List<Permission>> getPermissions() {
        List<Permission> responsePermissions = this.permissionService.searchPermissions();
        return ResponseEntity.status(HttpStatus.OK).body(responsePermissions);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Permission> getPermissionByName(@PathVariable String name) {
        Permission responseByName = this.permissionService.searchPermissionByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(responseByName);
    }
}
