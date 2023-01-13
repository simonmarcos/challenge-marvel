package com.test.challenge.service.marvel;

import com.test.challenge.service.marvel.model.CharacterMarvel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CharacterMarvelService {

    List<CharacterMarvel> findAll(Pageable pageable);

    List<CharacterMarvel> findByName(String name);
}
