package com.test.challenge.service;

import com.test.challenge.service.dto.CharacterMarvelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterCustomMarvelService {

    Page<CharacterMarvelDTO> findAllOfMarvelApi(Pageable pageable);

    CharacterMarvelDTO findByName(String name);
}
