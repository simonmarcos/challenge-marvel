package com.test.challenge.challenge.controller;

import com.test.challenge.challenge.exception.BusinessExceptions;
import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.service.CharacterCustomService;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private final CharacterCustomService characterCustomService;

    public CharacterController(CharacterCustomService characterCustomService) {
        this.characterCustomService = characterCustomService;
    }

    @GetMapping("/character/findAllFromMarvelApi")
    public ResponseEntity<List<CharacterDTO>> findAllFromMarvelApi(Pageable pageable) {
        Page<CharacterDTO> page = characterCustomService.findAllOfMarvelApi(pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/character/findAllByUser")
    public ResponseEntity<List<CharacterDTO>> findAllByUser(@RequestParam(name = "user") Long userId, Pageable pageable) {
        Page<CharacterDTO> page = characterCustomService.findAllByUserId(userId, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/character/findByName")
    public ResponseEntity<CharacterDTO> findByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(characterCustomService.findByName(name));
    }

    @PostMapping("/character/save")
    public ResponseEntity<List<CharacterDTO>> save(@Valid @RequestBody List<Character> characterList, @RequestParam(name = "userId") Long userId) throws URISyntaxException {
        List<CharacterDTO> characterDTOResponse = characterCustomService.saveAll(characterList, userId);

        if (characterDTOResponse.size() == 0) {
            throw new BusinessExceptions("MS-405", "Los personajes enviados ya se encuentran en la base de datos.", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.created(new URI("/api/character/save")).body(characterDTOResponse);
    }
}
