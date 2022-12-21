package com.test.challenge.challenge.service.impl;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.repository.UserRepository;
import com.test.challenge.challenge.service.UserService;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO save(User user) {
        return null;
    }

    @Override
    public UserDTO update(User user) {
        return null;
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return null;
    }
}
