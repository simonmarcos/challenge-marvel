package com.test.challenge.challenge.service.mapper;

import com.test.challenge.challenge.model.Character;
import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.dto.CharacterMarvelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterDTO entityToDTO(Character character);

    @Mapping(source = "id", target = "marvelId")
    Character dtoToEntity(CharacterDTO characterDTO);

    Character marvelDTOToEntity(CharacterMarvelDTO characterMarvelDTO);
}
