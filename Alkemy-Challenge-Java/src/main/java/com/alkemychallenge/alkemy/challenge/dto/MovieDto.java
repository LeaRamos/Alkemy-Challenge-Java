package com.alkemychallenge.alkemy.challenge.dto;

import com.alkemychallenge.alkemy.challenge.model.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto {
    private Long idMovie;
    private String image;
    @NotBlank
    @JsonProperty
    private String title;
    private LocalDate createdDate;

}
