package com.test.challenge.challenge.service.mapper;

import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterDTO characterToCharacterDTO(Character character);

    Character characterDTOToCharacter(CharacterDTO characterDTO);
}
