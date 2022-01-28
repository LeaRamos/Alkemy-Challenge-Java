package com.alkemychallenge.alkemy.challenge.service;

import com.alkemychallenge.alkemy.challenge.dto.MovieDto;
import com.alkemychallenge.alkemy.challenge.dto.MovieDetalleDto;
import com.alkemychallenge.alkemy.challenge.model.Movie;
import com.alkemychallenge.alkemy.challenge.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public MovieDetalleDto createMovie(MovieDetalleDto movieDetalleDto) {
        Movie movieEntity = modelMapper.map(movieDetalleDto, Movie.class);
        movieRepository.save(movieEntity);
        return modelMapper.map(movieEntity, MovieDetalleDto.class);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    @Transactional
    public MovieDetalleDto updateMovie(MovieDetalleDto movieDetalleDto, Long id) throws Exception {
        Movie movieEntity = modelMapper.map(movieDetalleDto, Movie.class);

        try {
            Movie movieEntityBuscado= movieRepository.getById(id);

            movieEntityBuscado.setCharacters(movieEntity.getCharacters());
            movieEntityBuscado.setCreatedDate(movieEntity.getCreatedDate());
            movieEntityBuscado.setImage(movieEntity.getImage());
            movieEntityBuscado.setGender(movieEntity.getGender());
            movieEntityBuscado.setQualification(movieEntity.getQualification());
            movieEntityBuscado.setTitle(movieEntity.getTitle());

            movieRepository.save(movieEntityBuscado);
            return modelMapper.map(movieEntity, MovieDetalleDto.class);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<MovieDto> getAll() {
        List<Movie> movieList= movieRepository.findAll();
        List<MovieDto> movieDtoList = movieList
                .stream()
                .map(movie -> modelMapper
                        .map(movie, MovieDto.class))
                .collect(Collectors.toList());
        return movieDtoList;
    }

    @Override
    public MovieDetalleDto getOne(Long id) {
        Movie movieEntity = movieRepository.getById(id);
        MovieDetalleDto movieDetalleDto =modelMapper.map(movieEntity, MovieDetalleDto.class);
        return movieDetalleDto;
    }

    @Override
    public List<MovieDetalleDto> getMovieByName(String name) {
        List<Movie> movieByNameList= movieRepository.getMovieByNameList(name);

        List<MovieDetalleDto> movieDetalleDtoList = movieByNameList.stream()
                                                                    .map(movie -> modelMapper
                                                                    .map(movie, MovieDetalleDto.class))
                                                                    .collect(Collectors.toList());
        return movieDetalleDtoList;
    }

    @Override
    public List<MovieDetalleDto> getMovieByIdGender(Long idGender) {
        List<Movie> movieByIdGenderList= movieRepository.getMovieByIdGenderList(idGender);

        List<MovieDetalleDto> movieDetalleDtoList = movieByIdGenderList.stream()
                                                                        .map(movie -> modelMapper
                                                                        .map(movie, MovieDetalleDto.class))
                                                                        .collect(Collectors.toList());
        return movieDetalleDtoList;
    }

    @Override
    public List<MovieDetalleDto> getMovieListOrderByDate(String orden) {
    String ascendente = "asc";
    String descendente = "desc";

        if (orden.equals(descendente)){
            List<Movie> movieListOrderByDate = movieRepository.getMovieListOrderDescByDate();

            List<MovieDetalleDto> movieDetalleDtoList = movieListOrderByDate.stream()
                                                                            .map(movie -> modelMapper
                                                                            .map(movie, MovieDetalleDto.class))
                                                                            .collect(Collectors.toList());
            return movieDetalleDtoList;
        }else{
            List<Movie> movieListOrderByDate = movieRepository.getMovieListOrderAscByDate();

            List<MovieDetalleDto> movieDetalleDtoList = movieListOrderByDate.stream()
                    .map(movie -> modelMapper
                            .map(movie, MovieDetalleDto.class))
                    .collect(Collectors.toList());
            return movieDetalleDtoList;
        }
    }


}
