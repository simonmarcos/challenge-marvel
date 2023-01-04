package com.test.challenge.challenge.service.impl;

import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.repository.CharacterRepository;
import com.test.challenge.challenge.service.CharacterService;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character save(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public List<Character> saveAll(List<Character> characterDTOList) {
        return characterRepository.saveAll(characterDTOList);
    }

    @Override
    public UserDTO update(CharacterDTO characterDTO) {
        return null;
    }

    @Override
    public Page<Character> findAllByUserId(Long userId, Pageable pageable) {
        return characterRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public Optional<Character> findByUserAndMarvelID(Long userId, String marvelId) {
        return characterRepository.findByUserAndMarvelID(userId, marvelId);
    }

    @Override
    public Page<Character> findAll(Pageable pageable) {
        return characterRepository.findAll(pageable);
    }

    @Override
    public Optional<Character> findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public Optional<Character> findByMarvelId(String marvelId) {
        return characterRepository.findByMarvelId(marvelId);
    }
}
