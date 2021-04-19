package com.dio.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.dto.request.PersonRequestDto;
import com.dio.dto.response.PersonResponseDto;
import com.dio.entities.Person;
import com.dio.services.PersonServiceImpl;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private final PersonServiceImpl personService;
	
	@Autowired
	public PersonController(PersonServiceImpl personService) {
		this.personService = personService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> getById(@PathVariable Long id) {
		Person result = personService.getById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<List<PersonResponseDto>> listAll() {
		List<Person> list = personService.listAll();
		List<PersonResponseDto> listDto = list
											.stream()
											.map(result -> new PersonResponseDto(result))
											.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<PersonResponseDto> save(@Valid @RequestBody PersonRequestDto requestDto){
		Person savePerson = personService.save(requestDto.transformToDto());
		
		return ResponseEntity.ok().body(new PersonResponseDto(savePerson));
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDto> update(@Valid @RequestBody PersonRequestDto requestDto, @PathVariable Long id){
		Person updatePerson = personService.update(requestDto.transformToDto());
		updatePerson.setId(id);
		
		return ResponseEntity.ok().body(new PersonResponseDto(updatePerson));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		personService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
