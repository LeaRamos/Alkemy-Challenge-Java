package com.alkemychallenge.alkemy.challenge.repository;

import com.alkemychallenge.alkemy.challenge.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {

    List<Character> findByNameContains( String name);

    List<Character> findByAge(Integer age);

    @Query(
            value = "select * from characters where characters.id in (SELECT fk_character " +
                    "FROM alkemy.rel_character_movie " +
                    "WHERE alkemy.rel_character_movie.fk_movie =:idMovie);",
            nativeQuery = true
    )
    List<Character> getCharacterByIdMovieList(@Param("idMovie") Long idMovie);
}
