package com.login.login.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.login.domain.entity.Permission;
import java.util.Optional;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, String>{
    Optional<Permission> findByName(String name);
}
