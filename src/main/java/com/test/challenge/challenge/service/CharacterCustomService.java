package com.test.challenge.challenge.service;

import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CharacterCustomService {

    List<CharacterDTO> saveAll(List<CharacterDTO> characterDTOList, Long userId);

    UserDTO update(CharacterDTO characterDTO);

    Page<CharacterDTO> findAll(Pageable pageable);

    CharacterDTO findByName(String name);

    Optional<Character> findByMarvelId(String marvelId);
}
