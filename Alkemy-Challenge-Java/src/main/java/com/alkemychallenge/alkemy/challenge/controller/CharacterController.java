package com.alkemychallenge.alkemy.challenge.controller;


import com.alkemychallenge.alkemy.challenge.dto.CharacterDetalleDto;
import com.alkemychallenge.alkemy.challenge.dto.CharacterDto;
import com.alkemychallenge.alkemy.challenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @GetMapping("")
    public ResponseEntity<List<CharacterDto>> getAll() {
        List<CharacterDto> characterDtoList = this.characterService.getAll();
        return ResponseEntity.ok().body(characterDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDetalleDto> getCharacter(@PathVariable(name = "id") Long id) {
        CharacterDetalleDto characterDetalleDto = this.characterService.getOne(id);
        return ResponseEntity.ok().body(characterDetalleDto);
    }

    @PostMapping("")
    public ResponseEntity<CharacterDetalleDto> createCharacter(@RequestBody CharacterDetalleDto character){
        CharacterDetalleDto characterDetalleDto = characterService.createCharacter(character);
        return ResponseEntity.ok().body(characterDetalleDto);
    }


    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CharacterDetalleDto> modify(@RequestBody CharacterDetalleDto character, @PathVariable Long id) throws Exception {

        CharacterDetalleDto characterDetalleDto = characterService.updateCharacter(character, id);

        return ResponseEntity.ok().body(characterDetalleDto);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {

        this.characterService.deleteCharacter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping( params = "name")
    public ResponseEntity<List<CharacterDetalleDto>> getCharacterByName(@Valid @RequestParam String name) {
        List<CharacterDetalleDto> characterDetalleDtoListByName = characterService.findByName(name);
        return ResponseEntity.ok().body(characterDetalleDtoListByName);
    }

    @GetMapping( params = "age")
    public ResponseEntity<List<CharacterDetalleDto>> getCharacterByAge(@Valid @RequestParam Integer age) {
        List<CharacterDetalleDto> characterDetalleDtoListByAge = characterService.findByAge(age);
        return ResponseEntity.ok().body(characterDetalleDtoListByAge);
    }

    @GetMapping( params = "idMovie")
    public ResponseEntity<List<CharacterDetalleDto>> getCharacterByIdMovie(@Valid @RequestParam Long idMovie) {
        List<CharacterDetalleDto> characterDetalleDtoListByIdMovie = characterService.findByIdMovie(idMovie);
        return ResponseEntity.ok().body(characterDetalleDtoListByIdMovie);
    }
}
