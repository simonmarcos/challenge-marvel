package com.test.challenge.challenge.service.impl;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.repository.UserRepository;
import com.test.challenge.challenge.service.UserService;
import com.test.challenge.challenge.service.dto.UserDTO;
import com.test.challenge.challenge.service.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.entityToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO update(User user) {
        return userMapper.entityToDTO(userRepository.save(user));
    }

    @Override
    public Optional<UserDTO> findOneByEmail(String email) {
        return Optional.ofNullable(userMapper.entityToDTO(userRepository.findOneByEmail(email).get()));
    }
}
