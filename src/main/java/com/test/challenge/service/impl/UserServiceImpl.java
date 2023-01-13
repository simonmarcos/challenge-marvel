package com.test.challenge.service.impl;

import com.test.challenge.model.User;
import com.test.challenge.repository.UserRepository;
import com.test.challenge.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
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
    public Optional<User> findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }
}
