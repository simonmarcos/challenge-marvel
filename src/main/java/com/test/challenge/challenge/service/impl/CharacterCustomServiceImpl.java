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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CharacterCustomServiceImpl implements CharacterCustomService {

    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterCustomServiceImpl(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @Override
    public List<CharacterDTO> saveAll(List<CharacterMarvelDTO> characterList, Long userId) {

        if (characterList.size() > 20) {
            throw new BusinessExceptions("MS-403", "No se pueden agregar más de 20 personajes.", HttpStatus.PRECONDITION_FAILED);
        }

        List<CharacterDTO> characterDTOSaved = new ArrayList<>();

        characterList.forEach(characterMarvelDTO -> {
            if (!findByMarvelId(characterMarvelDTO.getMarvelId()).isPresent()) {
                Character characterToSaved = characterMapper.marvelDTOToEntity(characterMarvelDTO);

                User user = new User();
                user.setId(userId);
                characterToSaved.setUser(user);

                Character characterSaved = characterService.save(characterToSaved);
                characterDTOSaved.add(characterMapper.entityToDTO(characterSaved));
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
    public Optional<Character> findByMarvelId(String marvelId) {
        return characterService.findByMarvelId(marvelId);
    }

}
