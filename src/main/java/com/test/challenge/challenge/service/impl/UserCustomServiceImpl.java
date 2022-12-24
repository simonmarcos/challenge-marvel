package com.test.challenge.challenge.service.impl;


import com.test.challenge.challenge.exception.BusinessExceptions;
import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.UserCustomService;
import com.test.challenge.challenge.service.UserService;
import com.test.challenge.challenge.service.dto.UserDTO;
import com.test.challenge.challenge.service.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserCustomServiceImpl implements UserCustomService {

    private final UserService userService;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserCustomServiceImpl(UserService userService, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO save(User user) {

        if (userService.findOneByEmail(user.getEmail()).isPresent()) {
            throw new BusinessExceptions("MS-421", "El email que desea registrar ya se encuentra registrado.", HttpStatus.PRECONDITION_FAILED);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.entityToDTO(userService.save(user));
    }

    @Override
    public Optional<UserDTO> findOneByEmail(String email) {
        return Optional.ofNullable(userMapper.entityToDTO(userService.findOneByEmail(email).get()));
    }
}
