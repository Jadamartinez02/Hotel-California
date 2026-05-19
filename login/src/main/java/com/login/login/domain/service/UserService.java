package com.login.login.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.login.login.domain.entity.User;
import com.login.login.infraestructure.repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public User saveUser(User data) {
        if (data.getEmail() == null || data.getPassword() == null || 
            data.getFirstName() == null || data.getLastName() == null || data.getDocument() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los campos requeridos no pueden estar vacíos");
        }

        Optional<User> existingUser = userRepository.findByEmail(data.getEmail());
        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El email ya está registrado");
        }

        Optional<User> existingDocument = userRepository.findByDocument(data.getDocument());
        if (existingDocument.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El documento ya está registrado");
        }

        return this.userRepository.save(data);
    }

    public List<User> searchUsers() {
        return this.userRepository.findAll();
    }

    public User searchUserById(String id) {
        Optional<User> searchByIdOptional = this.userRepository.findById(id);
        if (!searchByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        return searchByIdOptional.get();
    }

    public User searchUserByEmail(String email) {
        Optional<User> searchByEmailOptional = this.userRepository.findByEmail(email);
        if (!searchByEmailOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado por email");
        }
        return searchByEmailOptional.get();
    }

    public void deleteUserById(String id) {
        Optional<User> deleteByIdOptional = this.userRepository.findById(id);
        if (!deleteByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        this.userRepository.deleteById(id);
    }

    public User updateUser(String id, User data) {
        Optional<User> searchByIdOptional = userRepository.findById(id);
        if (!searchByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        User userToUpdate = searchByIdOptional.get();

        if (data.getFirstName() != null) {
            userToUpdate.setFirstName(data.getFirstName());
        }
        if (data.getLastName() != null) {
            userToUpdate.setLastName(data.getLastName());
        }
        if (data.getPhoneNumber() != null) {
            userToUpdate.setPhoneNumber(data.getPhoneNumber());
        }
        if (data.getBirthDate() != null) {
            userToUpdate.setBirthDate(data.getBirthDate());
        }
        if (data.getRole() != null) {
            userToUpdate.setRole(data.getRole());
        }

        return this.userRepository.save(userToUpdate);
    }
}
