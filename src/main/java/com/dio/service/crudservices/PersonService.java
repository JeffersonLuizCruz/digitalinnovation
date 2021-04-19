package com.dio.service.crudservices;

import java.util.List;

import com.dio.entities.Person;

public interface PersonService {
	
	Person getById(Long id);
	List<Person> listAll();
	Person save(Person person);
	Person update(Person person);
	void delete(Long id);

}
