package com.login.login.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.login.login.domain.entity.Role;
import com.login.login.infraestructure.repository.IRoleRepository;

@Service
public class RoleService {
    @Autowired
    IRoleRepository roleRepository;

    public Role saveRole(Role data) {
        if (data.getName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del rol es requerido");
        }

        Optional<Role> existingRole = roleRepository.findByName(data.getName());
        if (existingRole.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El rol ya existe");
        }

        return this.roleRepository.save(data);
    }

    public List<Role> searchRoles() {
        return this.roleRepository.findAll();
    }

    public Role searchRoleById(String id) {
        Optional<Role> searchByIdOptional = this.roleRepository.findById(id);
        if (!searchByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
        }
        return searchByIdOptional.get();
    }

    public Role searchRoleByName(String name) {
        Optional<Role> searchByNameOptional = this.roleRepository.findByName(name);
        if (!searchByNameOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado por nombre");
        }
        return searchByNameOptional.get();
    }

    public void deleteRoleById(String id) {
        Optional<Role> deleteByIdOptional = this.roleRepository.findById(id);
        if (!deleteByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
        }
        this.roleRepository.deleteById(id);
    }

    public Role updateRole(String id, Role data) {
        Optional<Role> searchByIdOptional = roleRepository.findById(id);
        if (!searchByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
        }
        Role roleToUpdate = searchByIdOptional.get();

        if (data.getName() != null) {
            roleToUpdate.setName(data.getName());
        }
        if (data.getCanEditRoom() != null) {
            roleToUpdate.setCanEditRoom(data.getCanEditRoom());
        }
        if (data.getCanViewRoom() != null) {
            roleToUpdate.setCanViewRoom(data.getCanViewRoom());
        }
        if (data.getCanPostOffers() != null) {
            roleToUpdate.setCanPostOffers(data.getCanPostOffers());
        }
        if (data.getCanEditPackage() != null) {
            roleToUpdate.setCanEditPackage(data.getCanEditPackage());
        }
        if (data.getPermissions() != null) {
            roleToUpdate.setPermissions(data.getPermissions());
        }

        return this.roleRepository.save(roleToUpdate);
    }
}
