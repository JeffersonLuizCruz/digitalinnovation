package com.digitalinnovation.services.crudservice;

import java.util.List;

import com.digitalinnovation.entities.Person;

public interface PersonService {
	
	Person getById(Long id);
	List<Person> listAll();
	Person save(Person person);
	Person update(Person person);
	void delete(Long id);
	

}
