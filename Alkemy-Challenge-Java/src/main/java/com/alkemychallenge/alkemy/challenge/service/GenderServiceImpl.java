package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.GenderDto;
import com.alkemychallenge.alkemy.challenge.model.Gender;
import com.alkemychallenge.alkemy.challenge.repository.GenderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    @Transactional
    public GenderDto createGender(GenderDto genderDto) {

       Gender genderEntity = modelMapper.map(genderDto, Gender.class);
        genderRepository.save(genderEntity);
        return modelMapper.map(genderEntity, GenderDto.class);

    }

    @Override
    public List<GenderDto> getAll() {
        List<Gender> genderList=genderRepository.findAll();
        List<GenderDto> genderDtoList= genderList.stream().map(gender -> modelMapper.map(gender,GenderDto.class)).collect(Collectors.toList());

        return genderDtoList;
    }

    @Override
    public GenderDto getOne(Long id) {
        Gender genderEntity= genderRepository.getById(id);
        GenderDto genderDto=modelMapper.map(genderEntity,GenderDto.class);

        return genderDto;
    }

    @Override
    public void deleteGender(Long id) {
        genderRepository.deleteById(id);

    }

    @Transactional
    @Override
    public GenderDto updateGender(GenderDto genderDto, Long id) {
        Gender genderEntity = modelMapper.map(genderDto,Gender.class);
        Gender genderEntitySearch= genderRepository.getById(id);

        genderEntitySearch.setImage(genderEntity.getImage());
        genderEntitySearch.setName(genderEntity.getName());

        genderRepository.save(genderEntitySearch);
        return modelMapper.map(genderEntity, GenderDto.class);


    }
}
