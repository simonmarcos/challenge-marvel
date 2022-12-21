package com.test.challenge.challenge.service.marvel.mapper;

import com.test.challenge.challenge.service.dto.CharacterDTO;
import com.test.challenge.challenge.service.marvel.model.CharacterMarvel;
import com.test.challenge.challenge.service.marvel.model.ThumbnailMarvel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CharacterMarvelMapper {
    @Mapping(source = "thumbnailMarvel", target = "thumbnail", qualifiedByName = "concatThumbnail")
    CharacterDTO characterMarvelToCharacterDTO(CharacterMarvel characterMarvel);

    @Named("concatThumbnail")
    static String concatThumbnail(ThumbnailMarvel thumbnailMarvel) {
        return thumbnailMarvel.getPath() + "." + thumbnailMarvel.getExtension();
    }
}
