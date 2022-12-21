package com.test.challenge.challenge.service;

import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> saveAll(List<CharacterDTO> characterDTOList, Long userId);

    UserDTO update(CharacterDTO characterDTO);

    Page<CharacterDTO> findAll(Pageable pageable);

    CharacterDTO findByName(String name);
}
