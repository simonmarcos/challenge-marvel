package com.test.challenge.challenge.service.marvel.mapper;

import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.marvel.model.CharacterMarvel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMarvelMapper {
    CharacterDTO characterMarvelToCharacterDTO(CharacterMarvel characterMarvel);
}
