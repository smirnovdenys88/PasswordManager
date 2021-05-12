package com.project.password.manager.secure.jwt.dao;

import com.project.password.manager.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUserName(String userName);

    UserEntity findByEmail(String email);

    UserEntity findByToken(String token);
}
