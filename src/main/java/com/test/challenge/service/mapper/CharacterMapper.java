package com.test.challenge.service.mapper;

import com.test.challenge.model.Character;
import com.test.challenge.service.dto.CharacterDTO;
import com.test.challenge.service.dto.CharacterMarvelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterDTO entityToDTO(Character character);

    @Mapping(source = "id", target = "marvelId")
    Character dtoToEntity(CharacterDTO characterDTO);

    Character marvelDTOToEntity(CharacterMarvelDTO characterMarvelDTO);
}
