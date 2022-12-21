package com.test.challenge.challenge.controller;

import com.test.challenge.challenge.exception.BusinessExceptions;
import com.test.challenge.challenge.service.CharacterService;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping("/character/save")
    public ResponseEntity<List<CharacterDTO>> save(@RequestBody List<CharacterDTO> characterDTOList, @RequestParam(name = "userId") Long userId) throws URISyntaxException {
        List<CharacterDTO> characterDTOResponse = characterService.saveAll(characterDTOList, userId);

        if (characterDTOResponse.size() == 0) {
            throw new BusinessExceptions("MS-405", "Los personajes enviados ya se encuentran en la base de datos.", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.created(new URI("/api/character/save")).body(characterDTOResponse);
    }
}
