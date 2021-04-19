package com.dio.repositories;


import java.time.LocalDate;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dio.entities.Person;
import com.dio.entities.Phone;
import com.dio.entities.enums.PhoneType;
import com.dio.repositoties.PersonRepository;

@SpringBootTest
public class PersonTest {
	
	@Autowired private PersonRepository personRepository;
	
	@Test
	public void save() {
		
		Phone phone = new Phone();
		phone.setNumber("988053100");
		phone.setType(PhoneType.COMMERCIAL);
		
		Person person = new Person(null, "Hugo", "Luiz", "08575874470", LocalDate.now());
		person.getPhones().add(phone);
		
		personRepository.save(person);
	}

}
