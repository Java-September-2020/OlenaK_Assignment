package com.olena.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.olena.relationships.models.License;
import com.olena.relationships.models.Person;
import com.olena.relationships.repositories.LicenseRepository;
import com.olena.relationships.repositories.PersonRepository;

@Service
public class PLService {
	private final PersonRepository personRepository;
	private final LicenseRepository licenseRepository;
	
	public PLService(PersonRepository personRepository, LicenseRepository licenseRepository) {
		super();
		this.personRepository = personRepository;
		this.licenseRepository = licenseRepository;
	}
	
	public Person getPerson(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	public List<Person> getPeople(){
		return personRepository.findAll();
	}
	
	public List<Person> getPeopleWithoutLicense(){
		return personRepository.findByLicenseIdIsNull();
	}
	
	public Person createPerson(Person people) {
		return personRepository.save(people);
	}
	
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return licenseRepository.save(license);
	}
	public int getLicenseNumber() {
		License license=licenseRepository.findByOrderByNumberDesc();
		if(license == null)
			return 1;
		int largestNumber = license.getNumber();
		largestNumber++;
		return (largestNumber);
	}
}
