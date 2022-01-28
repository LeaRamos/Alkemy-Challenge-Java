package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.MovieDto;
import com.alkemychallenge.alkemy.challenge.dto.MovieDetalleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

public interface MovieService {

    MovieDetalleDto createMovie(@Valid MovieDetalleDto createMovie );
    void deleteMovie(Long id);
    MovieDetalleDto updateMovie(@Valid MovieDetalleDto movieDetalleDto, Long id) throws Exception;
    List<MovieDto> getAll();
    MovieDetalleDto getOne(Long id);

    List<MovieDetalleDto> getMovieByName(String name);
    List<MovieDetalleDto> getMovieByIdGender(Long idGender);

    List<MovieDetalleDto> getMovieListOrderByDate(String orden);
}
