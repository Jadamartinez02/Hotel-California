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

import com.login.login.domain.entity.Employee;
import com.login.login.domain.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee data) {
        Employee responseSave = this.employeeService.saveEmployee(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee data) {
        Employee responseUpdate = this.employeeService.updateEmployee(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(responseUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        this.employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee responseById = this.employeeService.searchEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseById);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> responseEmployees = this.employeeService.searchEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(responseEmployees);
    }

    @GetMapping("/code/{employeeCode}")
    public ResponseEntity<Employee> getEmployeeByCode(@PathVariable String employeeCode) {
        Employee responseByCode = this.employeeService.searchEmployeeByCode(employeeCode);
        return ResponseEntity.status(HttpStatus.OK).body(responseByCode);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        Employee responseByEmail = this.employeeService.searchEmployeeByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(responseByEmail);
    }
}
