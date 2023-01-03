package com.test.challenge.challenge.service.impl;

import com.test.challenge.challenge.exception.BusinessExceptions;
import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.CharacterCustomService;
import com.test.challenge.challenge.service.CharacterService;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.CharacterMarvelDTO;
import com.test.challenge.challenge.service.dto.UserDTO;
import com.test.challenge.challenge.service.mapper.CharacterMapper;
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
import java.util.Optional;

@Service
@Transactional
public class CharacterCustomServiceImpl implements CharacterCustomService {

    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    private final CharacterMarvelService characterMarvelService;
    private final CharacterMarvelMapper characterMarvelMapper;

    public CharacterCustomServiceImpl(CharacterService characterService, CharacterMapper characterMapper, CharacterMarvelService characterMarvelService, CharacterMarvelMapper characterMarvelMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
        this.characterMarvelService = characterMarvelService;
        this.characterMarvelMapper = characterMarvelMapper;
    }

    @Override
    public List<CharacterDTO> saveAll(List<Character> characterList, Long userId) {

        if (characterList.size() > 20) {
            throw new BusinessExceptions("MS-403", "No se pueden agregar más de 20 personajes.", HttpStatus.PRECONDITION_FAILED);
        }

        List<CharacterDTO> characterDTOSaved = new ArrayList<>();

        characterList.forEach(character -> {
            if (!findByMarvelId(character.getId().toString()).isPresent()) {

                User user = new User();
                user.setId(userId);
                character.setUser(user);

                characterService.save(character);
                characterDTOSaved.add(characterMapper.entityToDTO(character));
            }
        });

        return characterDTOSaved;
    }

    @Override
    public UserDTO update(CharacterDTO characterDTO) {
        return null;
    }

    @Override
    public Page<CharacterDTO> findAllByUserId(Long userId, Pageable pageable) {
        Page<Character> characters = characterService.findAllByUserId(userId, pageable);

        List<CharacterDTO> characterDTOList = new ArrayList<>();

        characters.getContent().forEach(character -> characterDTOList.add(characterMapper.entityToDTO(character)));

        return new PageImpl<>(characterDTOList);
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

    @Override
    public Optional<Character> findByMarvelId(String marvelId) {
        return characterService.findByMarvelId(marvelId);
    }

}
