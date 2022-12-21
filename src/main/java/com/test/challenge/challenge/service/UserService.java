package com.test.challenge.challenge.service;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDTO save(User user);

    UserDTO update(User user);

    Page<UserDTO> findAll(Pageable pageable);
}
