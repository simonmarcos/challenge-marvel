package com.test.challenge.challenge.service;

import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CharacterService {

    Character save(Character character);

    List<Character> saveAll(List<Character> characterDTOList);

    UserDTO update(CharacterDTO characterDTO);

    Page<Character> findAllByUserId(Long id, Pageable pageable);

    Page<Character> findAll(Pageable pageable);

    Optional<Character> findByName(String name);

    Optional<Character> findByMarvelId(String marvelId);
}
