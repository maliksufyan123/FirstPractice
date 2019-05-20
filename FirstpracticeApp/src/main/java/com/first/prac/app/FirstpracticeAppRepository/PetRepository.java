package com.first.prac.app.FirstpracticeAppRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.prac.app.FirstpracticeAppEntities.Pet;


@Repository
public interface PetRepository extends JpaRepository <Pet, Integer> {

}
