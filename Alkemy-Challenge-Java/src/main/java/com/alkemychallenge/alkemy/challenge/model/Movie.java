package com.alkemychallenge.alkemy.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="movie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;


    @Column(name = "image")
    private String image;


    @Column(name = "title")
    private String title;


    @Column(name = "created_date")
    private LocalDate createdDate;


    @Column(name = "qualification")
    private Integer qualification;

    @ManyToMany(mappedBy = "movies")
    private List<Character> characters;

    @ManyToOne(cascade = CascadeType.ALL)
    private Gender gender;
}
