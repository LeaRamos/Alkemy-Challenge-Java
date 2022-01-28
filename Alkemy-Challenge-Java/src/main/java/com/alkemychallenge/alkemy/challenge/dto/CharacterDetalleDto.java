package com.alkemychallenge.alkemy.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CharacterDetalleDto {

    private Long id;
    private String image;
    @NotBlank
    @JsonProperty
    private String name;

    private Integer age;
    private Double weight;
    private String history;
    private List<MovieDto> movies;

}
