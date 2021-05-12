package com.project.password.manager.service;

import com.project.password.manager.models.UserEntity;
import com.project.password.manager.secure.jwt.dto.UserDto;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    UserEntity findByEmail(String email);

    void saveDto(UserDto user);

    UserEntity findByToken(String token);

    void save(UserEntity user);

    ResponseEntity updateUser(UserDto user, HttpServletRequest request);

    ResponseEntity getUser(HttpServletRequest request);

    ResponseEntity insertDefaultAvatar(HttpServletRequest request);

    UserEntity getUserByRequest(HttpServletRequest request);
}
