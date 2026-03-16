package com.login.login.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.login.domain.entity.Permission;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, String>{
    Permission findByName(String name);
}
