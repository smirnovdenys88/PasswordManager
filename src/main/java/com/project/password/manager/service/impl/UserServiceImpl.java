package com.project.password.manager.service.impl;

import com.project.password.manager.models.UserEntity;
import com.project.password.manager.repositories.UserRepository;
import com.project.password.manager.secure.jwt.JwtTokenUtil;
import com.project.password.manager.secure.jwt.dto.UserDto;
import com.project.password.manager.service.UserService;
import com.project.password.manager.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import static com.project.password.manager.utils.Constants.DEFAULT_VALUE_NONE;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private Constants constants;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public List<UserEntity> findAll() {
        List<UserEntity> list = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void saveDto(UserDto user) {
        UserEntity newUser = new UserEntity();

        newUser.setUserName(user.getUsername());
        newUser.setAvatar("");
        newUser.setEmail(user.getEmail());
        newUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        newUser.setConfirmEmail(false);
        newUser.setToken(user.getActivationCode());

        newUser.setPhoneNumber(DEFAULT_VALUE_NONE);
        newUser.setCreateDate(new Date());

        userRepo.save(newUser);
    }

    @Override
    public UserEntity findByToken(String token) {
        return userRepo.findByToken(token);
    }

    @Override
    public void save(UserEntity user) {
        userRepo.save(user);
    }

    @Override
    public ResponseEntity updateUser(UserDto user, HttpServletRequest request) {
        try {
            UserEntity userEntity = userRepo.findById(jwtTokenUtil.getUserIdFromToken(request)).get();
            if (!userEntity.getId().equals(Long.valueOf(user.getId()))) {
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }

            userEntity.setPhoneNumber(user.getPhoneNumber());

            return new ResponseEntity(jwtTokenUtil.generateToken(userRepo.save(userEntity)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity getUser(HttpServletRequest request) {
        try {
            UserEntity user = userRepo.findById(jwtTokenUtil.getUserIdFromToken(request)).get();

            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity insertDefaultAvatar(HttpServletRequest request) {
        try {
            UserEntity user = userRepo.findById(jwtTokenUtil.getUserIdFromToken(request)).get();

//            awsAdapter.deleteObject(user.getAvatar());
//            user.setAvatar(constants.awsDomainSoapbox.concat("/").concat(constants.awsImageDefaultBackgroundChannel));
            return new ResponseEntity(userRepo.save(user).getAvatar(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public UserEntity getUserByRequest(HttpServletRequest request) {
        return userRepo.findById(jwtTokenUtil.getUserIdFromToken(request)).get();
    }
}
