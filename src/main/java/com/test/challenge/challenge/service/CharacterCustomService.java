package com.test.challenge.challenge.service;

import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.CharacterMarvelDTO;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CharacterCustomService {

    List<CharacterDTO> saveAll(List<CharacterMarvelDTO> characterDTOList, Long userId);

    UserDTO update(CharacterDTO characterDTO);

    Page<CharacterDTO> findAllByUserId(Long userId, Pageable pageable);

    Optional<Character> findByUserAndMarvelID(Long userId, String marvelId);

    Optional<Character> findByMarvelId(String marvelId);
}
