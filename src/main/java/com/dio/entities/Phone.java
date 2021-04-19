package com.dio.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.dio.entities.enums.PhoneType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class Phone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String number;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;

}
