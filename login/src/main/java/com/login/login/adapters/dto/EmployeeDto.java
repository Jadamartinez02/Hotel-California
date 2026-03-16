package com.login.login.adapters.dto;

import java.time.LocalDate;

public class EmployeeDto extends UserDto {

    private String employeeCode;
    private String position;
    private LocalDate hireDate;
    private Long salary;
    private String department;
    private boolean isActive;
    private String contractType;

    public EmployeeDto() {
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
