package com.login.login.domain.entity;

import java.time.LocalDate;
import java.util.List;

<<<<<<< Updated upstream
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
=======
import jakarta.persistence.*;

>>>>>>> Stashed changes

@Entity
public class Employee extends User {
    @Column(nullable = false, unique = true)
    private String employeeCode;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private LocalDate hireDate;
    @Column(nullable = false)
    private Long salary;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private boolean isActive;
    @Column(nullable = false)
    private String contractType;

    public Employee() {
    }

    public Employee(String id, String email, String password, String firstName, String lastName,
            String document, String phoneNumber, LocalDate birthDate, List<Reservation> reservations, Role role,
            String employeeCode, String position, LocalDate hireDate, Long salary, String department, boolean isActive,
            String contractType) {
        super(id, email, password, firstName, lastName, document, phoneNumber, birthDate, reservations, role);
        this.employeeCode = employeeCode;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
        this.department = department;
        this.isActive = isActive;
        this.contractType = contractType;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    

    
}
