package com.digitalinnovation.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.digitalinnovation.entities.enums.PhoneType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 25)
	private String firstName;
	
	@Column(nullable = false, length = 25)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
	
	@ElementCollection
	@CollectionTable(name = "phones")
	@Enumerated(EnumType.STRING)
	private Set<PhoneType> phones = new HashSet<>();
	

}
