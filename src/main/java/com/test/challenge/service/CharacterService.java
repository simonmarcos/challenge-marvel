package com.test.challenge.service;

import com.test.challenge.model.Character;
import com.test.challenge.service.dto.CharacterDTO;
import com.test.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CharacterService {

    Character save(Character character);

    Integer deleteByUserAndMarvelId(Long id, String marvelId);

    Page<Character> findAllByUserId(Long id, Pageable pageable);

    Optional<Character> findByUserAndMarvelID(Long userId, String marvelId);

    Optional<Character> findByName(String name);

    Optional<Character> findByMarvelId(String marvelId);
}
