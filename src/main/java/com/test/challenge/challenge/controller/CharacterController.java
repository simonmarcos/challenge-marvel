package com.test.challenge.challenge.controller;

import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.service.marvel.impl.CharacterMarvelServiceImpl;
import com.test.challenge.challenge.service.marvel.model.CharacterMarvel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private final CharacterMarvelServiceImpl characterService;

    public CharacterController(CharacterMarvelServiceImpl characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/character")
    public Character findAll() {
        List<CharacterMarvel> characterMarvelList = characterService.findByName("3-D Man");
        return null;
    }
}
