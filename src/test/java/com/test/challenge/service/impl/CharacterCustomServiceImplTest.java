package com.test.challenge.service.impl;

import com.test.challenge.exception.BusinessExceptions;
import com.test.challenge.model.Character;
import com.test.challenge.service.CharacterCustomService;
import com.test.challenge.service.CharacterService;
import com.test.challenge.service.dto.CharacterDTO;
import com.test.challenge.service.dto.CharacterMarvelDTO;
import com.test.challenge.service.mapper.CharacterMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CharacterCustomServiceImplTest {

    @Mock
    private CharacterCustomService characterCustomService;

    @Mock
    private CharacterService characterService;

    @InjectMocks
    private CharacterCustomServiceImpl characterCustomServiceImpl;

    @InjectMocks
    private CharacterServiceImpl characterServiceImpl;

    @Autowired
    private CharacterMapper characterMapper;

    @Test
    public void whenSavedListIsGreaterThanTwenty_returnBusinessException() {
        Exception exception = assertThrows(BusinessExceptions.class, () -> {
            List<CharacterMarvelDTO> characterDTOSList = new ArrayList<>();

            CharacterMarvelDTO characterDTO = new CharacterMarvelDTO();
            characterDTO.setMarvelId("1");

            for (int i = 0; i < 21; i++) {
                characterDTOSList.add(characterDTO);
            }

            List<CharacterDTO> savedList = characterCustomServiceImpl.saveAll(characterDTOSList, 1L);
        });

        String expectedMessage = "No se pueden agregar más de 20 personajes.";
        String currentMessage = exception.getMessage();

        assertEquals(currentMessage, expectedMessage);
    }

    @Test
    public void whenSaveCharacter_returnListWithCharacterSaved() {
        Character existingCharacter = new Character();
        existingCharacter.setMarvelId("Test2");
        Mockito.when(characterService.findByUserAndMarvelID(1L, existingCharacter.getMarvelId())).thenReturn(Optional.of(existingCharacter));

        List<CharacterMarvelDTO> characterListToSave = getListCharactersToClient();

        Mockito.when(characterCustomService.saveAll(characterListToSave, 1L)).thenReturn(getListCharactersToSave());
        List<CharacterDTO> characterListResponse = characterCustomServiceImpl.saveAll(characterListToSave, 1L);

        assertEquals(getListCharactersToSave(), characterListResponse);
    }

    private List<CharacterMarvelDTO> getListCharactersToClient() {
        List<CharacterMarvelDTO> characterListToClient = new ArrayList<>();

        CharacterMarvelDTO characterTestOne = new CharacterMarvelDTO();
        characterTestOne.setMarvelId("Test1");
        characterTestOne.setName("");
        characterTestOne.setDescription("");
        characterTestOne.setThumbnail("");
        characterTestOne.setModified("");

        CharacterMarvelDTO characterTestTwo = new CharacterMarvelDTO();
        characterTestTwo.setMarvelId("Test2");
        characterTestTwo.setName("");
        characterTestTwo.setDescription("");
        characterTestTwo.setThumbnail("");
        characterTestTwo.setModified("");

        CharacterMarvelDTO characterTestThree = new CharacterMarvelDTO();
        characterTestThree.setMarvelId("Test3");
        characterTestThree.setName("");
        characterTestThree.setDescription("");
        characterTestThree.setThumbnail("");
        characterTestThree.setModified("");

        characterListToClient.add(characterTestOne);
        characterListToClient.add(characterTestTwo);
        characterListToClient.add(characterTestThree);

        return characterListToClient;
    }

    private List<CharacterDTO> getListCharactersToSave() {
        List<CharacterDTO> characterListToSave = new ArrayList<>();

        CharacterDTO characterTestOne = new CharacterDTO();
        characterTestOne.setId(1L);
        characterTestOne.setMarvelId("Test1");
        characterTestOne.setName("");
        characterTestOne.setDescription("");
        characterTestOne.setThumbnail("");
        characterTestOne.setModified("");

        CharacterDTO characterTestThree = new CharacterDTO();
        characterTestThree.setId(3L);
        characterTestThree.setMarvelId("Test3");
        characterTestThree.setName("");
        characterTestThree.setDescription("");
        characterTestThree.setThumbnail("");
        characterTestThree.setModified("");

        characterListToSave.add(characterTestOne);
        characterListToSave.add(characterTestThree);

        return characterListToSave;
    }
}
