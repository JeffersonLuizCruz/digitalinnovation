package com.dio.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Set;

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
		Person person = new Person(null, "Hugo", "Luiz", "08575874470", LocalDate.now());
		person.getPhones().add((Phone) Set.of("988053100", "988053501"));
		person.getPhones().add((Phone) Set.of(PhoneType.COMMERCIAL));
		
		assertThat(person.getId()).isEqualTo(null);
		
		personRepository.save(person);
	}

}
