package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.CharacterDetalleDto;
import com.alkemychallenge.alkemy.challenge.dto.CharacterDto;

import javax.validation.Valid;
import java.util.List;

public interface CharacterService {

    CharacterDetalleDto createCharacter(@Valid CharacterDetalleDto characterDetalleDto);
    List<CharacterDto> getAll();
    CharacterDetalleDto getOne(Long id);
    void deleteCharacter(Long id);
    CharacterDetalleDto updateCharacter(@Valid CharacterDetalleDto characterDetalleDto, Long id) throws Exception;

    List<CharacterDetalleDto> findByName(String name);
    List<CharacterDetalleDto> findByAge(Integer age);
    List<CharacterDetalleDto> findByIdMovie(Long idMovie);
}
