package com.test.challenge.challenge.controller;

import com.test.challenge.challenge.exception.RequestException;
import com.test.challenge.challenge.service.CharacterService;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/character")
    public ResponseEntity<List<CharacterDTO>> findAll(Pageable pageable) {
        Page<CharacterDTO> page = characterService.findAll(pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/character/findByName")
    public ResponseEntity<CharacterDTO> findByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(characterService.findByName(name));
    }
}
