package com.test.challenge.challenge.service.impl;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.repository.UserRepository;
import com.test.challenge.challenge.service.UserService;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<User> findByOneEmail(String email) {
        return userRepository.findOneByEmail(email);
    }
}
