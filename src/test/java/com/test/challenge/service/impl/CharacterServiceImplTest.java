package com.test.challenge.service.impl;

import com.test.challenge.model.Character;
import com.test.challenge.model.User;
import com.test.challenge.repository.CharacterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CharacterServiceImplTest {

    @Mock
    private final CharacterRepository characterRepository;

    @InjectMocks
    private final CharacterServiceImpl characterServiceImpl;

    private Character defaultValueCharacter;

    public CharacterServiceImplTest() {
        characterRepository = null;
        characterServiceImpl = null;
    }

    @Before
    public void initialize() {
        defaultValueCharacter = new Character();
        defaultValueCharacter.setId(1L);
        defaultValueCharacter.setName("Test");
        defaultValueCharacter.setMarvelId("12345");
        defaultValueCharacter.setThumbnail("test.jpg");
        defaultValueCharacter.setDescription("Test");

        User user = new User();
        user.setId(1L);
        user.setEmail("test@test.com");

        defaultValueCharacter.setUser(user);
    }

    @Test
    public void whenFindByNameCharacter_returnCharacter() {
        Mockito.when(characterRepository.findByName(defaultValueCharacter.getName())).thenReturn(Optional.of(defaultValueCharacter));

        Optional<Character> foundCharacter = characterServiceImpl.findByName("Test");

        assertTrue(foundCharacter.isPresent());
        assertEquals(defaultValueCharacter, foundCharacter.get());
    }

    @Test
    public void whenFindByMarvelIdCharacter_returnCharacter() {
        Mockito.when(characterRepository.findByMarvelId(defaultValueCharacter.getMarvelId())).thenReturn(Optional.of(defaultValueCharacter));

        Optional<Character> foundCharacter = characterServiceImpl.findByMarvelId("12345");

        assertTrue(foundCharacter.isPresent());
        assertEquals(defaultValueCharacter, foundCharacter.get());
    }

    @Test
    public void whenFindByUserAndMarvelIdCharacter_returnCharacter() {
        Mockito.when(characterRepository.findByUserAndMarvelID(defaultValueCharacter.getUser().getId(), defaultValueCharacter.getMarvelId())).thenReturn(Optional.of(defaultValueCharacter));

        Optional<Character> foundCharacter = characterServiceImpl.findByUserAndMarvelID(1L, "12345");

        assertTrue(foundCharacter.isPresent());
        assertEquals(defaultValueCharacter, foundCharacter.get());
    }


    @Test
    public void whenUpdatedCharacter_returnSuccessfull() {
        Mockito.when(characterRepository.save(defaultValueCharacter)).thenReturn(defaultValueCharacter);

        Character character = new Character();
        character.setId(1L);
        character.setMarvelId("12345");
        character.setThumbnail("test.jpg");
        character.setDescription("Test");

        Character characterSaved = characterServiceImpl.save(character);

        assertEquals(defaultValueCharacter, characterSaved);
        Mockito.verify(characterRepository, Mockito.times(1)).save(defaultValueCharacter);
    }
}
