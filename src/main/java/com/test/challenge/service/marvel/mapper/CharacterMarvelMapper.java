package com.test.challenge.service.marvel.mapper;

import com.test.challenge.service.dto.CharacterMarvelDTO;
import com.test.challenge.service.marvel.model.CharacterMarvel;
import com.test.challenge.service.marvel.model.ThumbnailMarvel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CharacterMarvelMapper {
    @Mapping(source = "id", target = "marvelId")
    @Mapping(source = "thumbnailMarvel", target = "thumbnail", qualifiedByName = "concatThumbnail")
    CharacterMarvelDTO characterMarvelToCharacterMarvelDTO(CharacterMarvel characterMarvel);

    @Named("concatThumbnail")
    static String concatThumbnail(ThumbnailMarvel thumbnailMarvel) {
        return thumbnailMarvel.getPath() + "." + thumbnailMarvel.getExtension();
    }
}
