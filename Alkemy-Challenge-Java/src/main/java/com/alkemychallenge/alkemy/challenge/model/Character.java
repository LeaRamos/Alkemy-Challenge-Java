package com.alkemychallenge.alkemy.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name="name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "weight")
    private Double weight;


    @Column(name = "history")
    private String history;

    @JoinTable(
            name = "rel_character_movie",
            joinColumns = @JoinColumn(name = "FK_CHARACTER", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_MOVIE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Movie> movies;

}
