package com.project.password.manager.repositories;

import com.project.password.manager.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByToken(String token);

    UserEntity findByUserName(String username);
}
