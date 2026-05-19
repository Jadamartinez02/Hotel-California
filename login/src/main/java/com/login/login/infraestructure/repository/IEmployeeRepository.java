package com.login.login.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.login.domain.entity.Employee;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> findByEmployeeCode(String employeeCode);
    Optional<Employee> findByEmail(String email);
}
