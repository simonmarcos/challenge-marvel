package com.test.challenge.challenge.service;

import com.test.challenge.challenge.model.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    User update(User user);

    Optional<User> findOneByEmail(String email);
}
