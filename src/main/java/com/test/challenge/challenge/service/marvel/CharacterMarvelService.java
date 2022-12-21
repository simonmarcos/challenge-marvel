package com.test.challenge.challenge.service.marvel;

import com.test.challenge.challenge.service.marvel.model.CharacterMarvel;

import java.util.List;

public interface CharacterMarvelService {

    List<CharacterMarvel> findByName(String name);
}
