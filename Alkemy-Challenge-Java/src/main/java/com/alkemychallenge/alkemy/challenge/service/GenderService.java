package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.GenderDto;

import javax.validation.Valid;
import java.util.List;

public interface GenderService {

    GenderDto createGender(@Valid GenderDto genderDto);
    List<GenderDto> getAll();
    GenderDto getOne(Long id);
    void deleteGender(Long id);
    GenderDto updateGender(@Valid GenderDto genderDto , Long id);


}
