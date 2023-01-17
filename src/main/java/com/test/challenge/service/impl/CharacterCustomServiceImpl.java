package com.test.challenge.service.impl;

import com.test.challenge.exception.BusinessExceptions;
import com.test.challenge.model.Character;
import com.test.challenge.model.User;
import com.test.challenge.service.CharacterCustomService;
import com.test.challenge.service.CharacterService;
import com.test.challenge.service.dto.CharacterDTO;
import com.test.challenge.service.dto.CharacterMarvelDTO;
import com.test.challenge.service.dto.UserDTO;
import com.test.challenge.service.mapper.CharacterMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        List<Character> characterListToSave = characterService.saveAll(validateCharacterListToSave(characterList, userId));

        return characterListToSave.stream().map(characterMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO update(CharacterDTO characterDTO) {
        return null;
    }

    @Override
    public boolean deleteByUserAndMarvelId(Long id, String marvelId) {
        return characterService.deleteByUserAndMarvelId(id, marvelId) > 0;
    }

    @Override
    public Page<CharacterDTO> findAllByUserId(Long userId, Pageable pageable) {
        Page<Character> characters = characterService.findAllByUserId(userId, pageable);

        List<CharacterDTO> characterDTOList = new ArrayList<>();

        characters.getContent().forEach(character -> characterDTOList.add(characterMapper.entityToDTO(character)));
        return new PageImpl<>(characterDTOList);
    }

    private List<Character> validateCharacterListToSave(List<CharacterMarvelDTO> characterListToSave, Long userId) {
        List<Character> listCharacterToSave = new ArrayList<>();

        characterListToSave.forEach(characterMarvelDTO -> {
            Optional<Character> characterOptional = characterService.findByUserAndMarvelID(userId, characterMarvelDTO.getMarvelId());
            if (!characterOptional.isPresent()) {
                User user = new User();
                user.setId(userId);

                Character characterToSave = characterMapper.marvelDTOToEntity(characterMarvelDTO);
                characterToSave.setUser(user);

                listCharacterToSave.add(characterToSave);
            }
        });

        return listCharacterToSave;
    }
}
