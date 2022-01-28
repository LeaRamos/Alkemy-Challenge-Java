package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.CharacterDetalleDto;
import com.alkemychallenge.alkemy.challenge.dto.CharacterDto;
import com.alkemychallenge.alkemy.challenge.model.Character;
import com.alkemychallenge.alkemy.challenge.repository.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import java.util.stream.Collectors;
import java.util.List;

@Service
@Validated
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public CharacterDetalleDto createCharacter(CharacterDetalleDto characterDetalleDto) {
        Character characterEntity = modelMapper.map(characterDetalleDto, Character.class);
         characterRepository.save(characterEntity);
        return modelMapper.map(characterEntity, CharacterDetalleDto.class);
    }

    @Override
    public List<CharacterDto> getAll() {
        List<Character> characterList= characterRepository.findAll();
        List<CharacterDto> characterDtoList= characterList
                .stream()
                .map(character -> modelMapper
                        .map(character, CharacterDto.class))
                .collect(Collectors.toList());
        return characterDtoList;
    }

    @Override
    public CharacterDetalleDto getOne(Long id) {
        Character characterEntity = characterRepository.getById(id);
        CharacterDetalleDto characterDetalleDto =modelMapper.map(characterEntity, CharacterDetalleDto.class);
        return characterDetalleDto;
    }

    @Override
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CharacterDetalleDto updateCharacter(CharacterDetalleDto characterDetalleDto, Long id) throws Exception{
        Character characterEntity = modelMapper.map(characterDetalleDto, Character.class);
        try{

            Character characterEntityBuscado= characterRepository.getById(id);
            characterEntityBuscado.setName(characterEntity.getName());
            characterEntityBuscado.setAge(characterEntity.getAge());
            characterEntityBuscado.setWeight(characterEntity.getWeight());
            characterEntityBuscado.setImage(characterEntity.getImage());
            characterEntityBuscado.setHistory(characterEntity.getHistory());
            characterEntityBuscado.setMovies(characterEntity.getMovies());

            characterRepository.save(characterEntityBuscado);
            return modelMapper.map(characterEntity, CharacterDetalleDto.class);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<CharacterDetalleDto> findByName(String name) {
        List<Character> characterFindByNameList= characterRepository.findByNameContains(name);

        List<CharacterDetalleDto> characterDetalleDtoList= characterFindByNameList.stream()
                .map(character -> modelMapper
                        .map(character, CharacterDetalleDto.class))
                .collect(Collectors.toList());
        return characterDetalleDtoList;
    }



    @Override
    public List<CharacterDetalleDto> findByAge(Integer age) {
        List<Character> characterFindByAgeList= characterRepository.findByAge(age);
        List<CharacterDetalleDto> characterDetalleDtoList= characterFindByAgeList.stream()
                .map(character -> modelMapper
                        .map(character, CharacterDetalleDto.class))
                .collect(Collectors.toList());
        return characterDetalleDtoList;
    }

    @Override
    public List<CharacterDetalleDto> findByIdMovie(Long idMovie) {
        List<Character> characterFindByIdMovieList= characterRepository.getCharacterByIdMovieList(idMovie);
        List<CharacterDetalleDto> characterDetalleDtoList= characterFindByIdMovieList.stream()
                .map(character -> modelMapper
                        .map(character, CharacterDetalleDto.class))
                .collect(Collectors.toList());
        return characterDetalleDtoList;
    }
}
