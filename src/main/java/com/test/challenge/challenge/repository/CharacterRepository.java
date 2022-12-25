package com.test.challenge.challenge.repository;

import com.test.challenge.challenge.model.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    Optional<Character> findByName(String name);

    @Query("SELECT character FROM Character character WHERE character.user = :user")
    Page<Character> findAllByUserId(@Param("user") Long user, Pageable pageable);

    Optional<Character> findByMarvelId(String marvelId);
}
