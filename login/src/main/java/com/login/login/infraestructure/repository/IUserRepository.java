
package com.login.login.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.login.login.domain.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String>{
    Optional<User> findUserByEmail(String email);
}
