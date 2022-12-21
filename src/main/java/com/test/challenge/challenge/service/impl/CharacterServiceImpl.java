package com.test.challenge.challenge.service.impl;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.CharacterService;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.UserDTO;
import com.test.challenge.challenge.service.marvel.mapper.CharacterMarvelMapper;
import com.test.challenge.challenge.service.marvel.CharacterMarvelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterMarvelService characterMarvelService;
    private final CharacterMarvelMapper characterMarvelMapper;

    public CharacterServiceImpl(CharacterMarvelService characterMarvelService, CharacterMarvelMapper characterMarvelMapper) {
        this.characterMarvelService = characterMarvelService;
        this.characterMarvelMapper = characterMarvelMapper;
    }

    @Override
    public UserDTO save(User user) {
        return null;
    }

    @Override
    public UserDTO update(User user) {
        return null;
    }

    @Override
    public Page<CharacterDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CharacterDTO findByName(String name) {
        return characterMarvelMapper.characterMarvelToCharacterDTO(characterMarvelService.findByName(name)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "GAF not found by id " + name)));
    }
}
