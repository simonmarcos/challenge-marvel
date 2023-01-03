package com.test.challenge.challenge.service.impl;

import com.test.challenge.challenge.service.CharacterCustomMarvelService;
import com.test.challenge.challenge.service.dto.CharacterMarvelDTO;
import com.test.challenge.challenge.service.marvel.CharacterMarvelService;
import com.test.challenge.challenge.service.marvel.mapper.CharacterMarvelMapper;
import com.test.challenge.challenge.service.marvel.model.CharacterMarvel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CharacterCustomMarvelServiceImpl implements CharacterCustomMarvelService {

    private final CharacterMarvelService characterMarvelService;
    private final CharacterMarvelMapper characterMarvelMapper;

    public CharacterCustomMarvelServiceImpl(CharacterMarvelService characterMarvelService, CharacterMarvelMapper characterMarvelMapper) {
        this.characterMarvelService = characterMarvelService;
        this.characterMarvelMapper = characterMarvelMapper;
    }

    @Override
    public Page<CharacterMarvelDTO> findAllOfMarvelApi(Pageable pageable) {
        List<CharacterMarvel> characterMarvelListResponse = characterMarvelService.findAll(pageable);

        List<CharacterMarvelDTO> characterDTOList = new ArrayList<>();
        characterMarvelListResponse.forEach(characterMarvel -> characterDTOList.add(characterMarvelMapper.characterMarvelToCharacterMarvelDTO(characterMarvel)));

        return new PageImpl<>(characterDTOList);
    }

    @Override
    public CharacterMarvelDTO findByName(String name) {
        return characterMarvelMapper.characterMarvelToCharacterMarvelDTO(characterMarvelService.findByName(name)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found by name " + name)));
    }
}
