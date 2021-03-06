package com.digitalinnovation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovation.entities.Person;
import com.digitalinnovation.repositories.PersonRepository;
import com.digitalinnovation.services.crudservice.PersonService;
import com.digitalinnovation.services.exception.BadRequestException;
import com.digitalinnovation.services.exception.NotFoundException;

@Service
public class PersonServiceImpl implements PersonService{
	
	private final PersonRepository personRepository;
	
	@Autowi
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
