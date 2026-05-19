package com.login.login.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.login.login.domain.entity.Employee;
import com.login.login.infraestructure.repository.IEmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee data) {
        if (data.getEmployeeCode() == null || data.getEmail() == null || 
            data.getPassword() == null || data.getFirstName() == null || 
            data.getLastName() == null || data.getDocument() == null ||
            data.getPosition() == null || data.getHireDate() == null || 
            data.getSalary() == null || data.getDepartment() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los campos requeridos no pueden estar vacíos");
        }

        Optional<Employee> existingEmployeeCode = employeeRepository.findByEmployeeCode(data.getEmployeeCode());
        if (existingEmployeeCode.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El código de empleado ya existe");
        }

        Optional<Employee> existingEmail = employeeRepository.findByEmail(data.getEmail());
        if (existingEmail.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El email ya está registrado");
        }

        return this.employeeRepository.save(data);
    }

    public List<Employee> searchEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee searchEmployeeById(String id) {
        Optional<Employee> searchByIdOptional = this.employeeRepository.findById(id);
        if (!searchByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        }
        return searchByIdOptional.get();
    }

    public Employee searchEmployeeByCode(String employeeCode) {
        Optional<Employee> searchByCodeOptional = this.employeeRepository.findByEmployeeCode(employeeCode);
        if (!searchByCodeOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado por código");
        }
        return searchByCodeOptional.get();
    }

    public Employee searchEmployeeByEmail(String email) {
        Optional<Employee> searchByEmailOptional = this.employeeRepository.findByEmail(email);
        if (!searchByEmailOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado por email");
        }
        return searchByEmailOptional.get();
    }

    public void deleteEmployeeById(String id) {
        Optional<Employee> deleteByIdOptional = this.employeeRepository.findById(id);
        if (!deleteByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        }
        this.employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(String id, Employee data) {
        Optional<Employee> searchByIdOptional = employeeRepository.findById(id);
        if (!searchByIdOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        }
        Employee employeeToUpdate = searchByIdOptional.get();

        if (data.getFirstName() != null) {
            employeeToUpdate.setFirstName(data.getFirstName());
        }
        if (data.getLastName() != null) {
            employeeToUpdate.setLastName(data.getLastName());
        }
        if (data.getPhoneNumber() != null) {
            employeeToUpdate.setPhoneNumber(data.getPhoneNumber());
        }
        if (data.getPosition() != null) {
            employeeToUpdate.setPosition(data.getPosition());
        }
        if (data.getSalary() != null) {
            employeeToUpdate.setSalary(data.getSalary());
        }
        if (data.getDepartment() != null) {
            employeeToUpdate.setDepartment(data.getDepartment());
        }
        if (data.getRole() != null) {
            employeeToUpdate.setRole(data.getRole());
        }
        employeeToUpdate.setActive(data.isActive());

        return this.employeeRepository.save(employeeToUpdate);
    }
}
