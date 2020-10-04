package com.olena.dojoAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.olena.dojoAndNinjas.models.Dojo;
import com.olena.dojoAndNinjas.models.Ninja;
import com.olena.dojoAndNinjas.repositories.DojoRepository;
import com.olena.dojoAndNinjas.repositories.NinjaRepository;

@Service
public class DNService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	public DNService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	public Dojo findDojo(Long id) {
		return this.dojoRepository.findById(id).orElse(null);
	}
}
