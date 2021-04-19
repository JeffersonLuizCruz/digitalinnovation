package com.dio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.entities.Person;
import com.dio.repositoties.PersonRepository;
import com.dio.service.crudservices.PersonService;
import com.dio.service.exceptions.BadRequestException;
import com.dio.service.exceptions.NotFoundException;

@Service
public class PersonServiceImpl implements PersonService{
	
	private final PersonRepository personRepository;
	
	@Autowired
	 public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person getById(Long id) {
		
		return verifyIfExist(id);
	}

	@Override
	public List<Person> listAll() {
		List<Person> result = personRepository.findAll();
		
		return result;
	}

	@Override
	public Person save(Person person) {
		person.setId(null);
		
		try {
			personRepository.findByCpf(person.getCpf());
		} catch (Exception e) {
			throw new BadRequestException("Usuário com esse CPF já existe!: " + person.getCpf());
		}
		
		Person savePerson = personRepository.save(person);
		
		return savePerson;
	}

	@Override
	public Person update(Person person) {
		Person updatePerson = verifyIfExist(person.getId());
		
		return updatePerson;
	}

	@Override
	public void delete(Long id) {
		Person deletePerson = verifyIfExist(id);
		personRepository.delete(deletePerson);
		
	}
	
	private Person verifyIfExist(Long id) {
		Optional<Person> result = personRepository.findById(id);
		result.orElseThrow(() -> new NotFoundException("Não existe usuário com " + id + "Tipo: " + Person.class));
		
		return result.get();
	}
}