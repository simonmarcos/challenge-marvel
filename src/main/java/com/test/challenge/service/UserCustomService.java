package com.test.challenge.service;

import com.test.challenge.model.User;
import com.test.challenge.service.dto.UserDTO;

import java.util.Optional;

public interface UserCustomService {
    UserDTO save(User user);

    Optional<UserDTO> findOneByEmail(String email);
}
