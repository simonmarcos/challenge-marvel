package com.test.challenge.service;

import com.test.challenge.service.dto.CharacterDTO;
import com.test.challenge.service.dto.CharacterMarvelDTO;
import com.test.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CharacterCustomService {

    List<CharacterDTO> saveAll(List<CharacterMarvelDTO> characterDTOList, Long userId);

    UserDTO update(CharacterDTO characterDTO);

    boolean deleteByUserAndMarvelId(Long id, String marvelId);

    Page<CharacterDTO> findAllByUserId(Long userId, Pageable pageable);

}
