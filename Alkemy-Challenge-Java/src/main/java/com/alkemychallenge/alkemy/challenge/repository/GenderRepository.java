package com.alkemychallenge.alkemy.challenge.repository;

import com.alkemychallenge.alkemy.challenge.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender,Long> {

}
