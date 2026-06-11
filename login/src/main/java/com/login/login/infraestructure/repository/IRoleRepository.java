package com.login.login.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.login.domain.entity.Role;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String>{
    Optional<Role> findByName(String name);
}
