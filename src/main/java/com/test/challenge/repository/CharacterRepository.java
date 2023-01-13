package com.test.challenge.repository;

import com.test.challenge.model.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Modifying
    @Query("DELETE FROM Character character WHERE character.user.id = :userId AND character.marvelId = :marvelId")
    Integer deleteByUserAndMarvelId(@Param("userId") Long userId, @Param("marvelId") String marvelId);

    Optional<Character> findByName(String name);

    @Query("SELECT character FROM Character character WHERE character.user.id = :userId")
    Page<Character> findAllByUserId(@Param("userId") Long userId, Pageable pageable);

    @Query("SELECT character FROM Character character WHERE character.user.id = :userId AND character.marvelId = :marvelId")
    Optional<Character> findByUserAndMarvelID(@Param("userId") Long userId, @Param("marvelId") String marvelId);

    Optional<Character> findByMarvelId(String marvelId);
}
