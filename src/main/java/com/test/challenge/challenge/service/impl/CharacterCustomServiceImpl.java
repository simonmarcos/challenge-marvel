package com.test.challenge.challenge.service.impl;

import com.test.challenge.challenge.exception.BusinessExceptions;
import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.CharacterCustomService;
import com.test.challenge.challenge.service.CharacterService;
import com.test.challenge.challenge.service.dto.CharacterDTO;
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
    public List<CharacterDTO> saveAll(List<CharacterDTO> characterDTOList, Long userId) {

        if (characterDTOList.size() > 20) {
            throw new BusinessExceptions("MS-403", "No se pueden agregar más de 20 personajes.", HttpStatus.PRECONDITION_FAILED);
        }

        List<CharacterDTO> characterDTOListSaved = new ArrayList<>();

        characterDTOList.forEach(characterDTO -> {
            if (!findByMarvelId(characterDTO.getId().toString()).isPresent()) {
                Character characterEntity = characterMapper.dtoToEntity(characterDTO);

                User user = new User();
                user.setId(userId);
                characterEntity.setUser(user);

                characterService.save(characterEntity);
                characterDTOListSaved.add(characterDTO);
            }
        });

        return characterDTOListSaved;
    }

    @Override
    public UserDTO update(CharacterDTO characterDTO) {
        return null;
    }

    @Override
    public Page<CharacterDTO> findAll(Pageable pageable) {
        List<CharacterMarvel> characterMarvelListResponse = characterMarvelService.findAll(pageable);

        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterMarvelListResponse.forEach(characterMarvel -> characterDTOList.add(characterMarvelMapper.characterMarvelToCharacterDTO(characterMarvel)));

        return new PageImpl<>(characterDTOList);
    }

    @Override
    public CharacterDTO findByName(String name) {
        return characterMarvelMapper.characterMarvelToCharacterDTO(characterMarvelService.findByName(name)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found by name " + name)));
    }

    @Override
    public Optional<Character> findByMarvelId(String marvelId) {
        return characterService.findByMarvelId(marvelId);
    }

}
