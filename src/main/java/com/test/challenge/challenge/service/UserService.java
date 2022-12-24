package com.test.challenge.challenge.service;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    UserDTO save(User user);

    UserDTO update(User user);

    Optional<UserDTO> findOneByEmail(String email);
}
