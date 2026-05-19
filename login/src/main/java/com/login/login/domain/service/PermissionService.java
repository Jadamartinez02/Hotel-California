package com.login.login.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.login.login.domain.entity.Permission;
import com.login.login.infraestructure.repository.IPermissionRepository;

@Service
public class PermissionService {
    @Autowired
    IPermissionRepository permissionRepository;

    public Permission savePermission(Permission data) {
        if (data.getName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del permiso es requerido");
        }

        Optional<Permission> existingPermission = permissionRepository.findByName(data.getName());
        if (existingPermission.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El permiso ya existe");
        }

        return this.permissionRepository.save(data);
    }

    public List<Permission> searchPermissions() {
        return this.permissionRepository.findAll();
    }

    public Permission searchPermissionById(String id) {
        Optional<Permission> searchByIdOptional = this.permissionRepository.findById(id);
        if (!searchByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado");
        }
        return searchByIdOptional.get();
    }

    public Permission searchPermissionByName(String name) {
        Optional<Permission> searchByNameOptional = this.permissionRepository.findByName(name);
        if (!searchByNameOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado por nombre");
        }
        return searchByNameOptional.get();
    }

    public void deletePermissionById(String id) {
        Optional<Permission> deleteByIdOptional = this.permissionRepository.findById(id);
        if (!deleteByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado");
        }
        this.permissionRepository.deleteById(id);
    }

    public Permission updatePermission(String id, Permission data) {
        Optional<Permission> searchByIdOptional = permissionRepository.findById(id);
        if (!searchByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado");
        }
        Permission permissionToUpdate = searchByIdOptional.get();

        if (data.getDescription() != null) {
            permissionToUpdate.setDescription(data.getDescription());
        }

        return this.permissionRepository.save(permissionToUpdate);
    }
}
