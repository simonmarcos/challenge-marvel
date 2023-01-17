package com.test.challenge.service.impl;

import com.test.challenge.model.Character;
import com.test.challenge.repository.CharacterRepository;
import com.test.challenge.service.CharacterService;
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
    public List<Character> saveAll(List<Character> characters) {
        return characterRepository.saveAll(characters);
    }

    @Override
    public Integer deleteByUserAndMarvelId(Long id, String marvelId) {
        return characterRepository.deleteByUserAndMarvelId(id, marvelId);
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
    public Optional<Character> findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public Optional<Character> findByMarvelId(String marvelId) {
        return characterRepository.findByMarvelId(marvelId);
    }
}
