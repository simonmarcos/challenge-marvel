package com.test.challenge.challenge.service;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterService {

    UserDTO save(User user);

    UserDTO update(User user);

    Page<CharacterDTO> findAll(Pageable pageable);

    CharacterDTO findByName(String name);
}
