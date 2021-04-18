package com.digitalinnovation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinnovation.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
