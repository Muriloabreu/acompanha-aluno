package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.acompanhaaluno.models.SchoolModel;
import com.api.acompanhaaluno.repositories.SchoolRepository;

import jakarta.transaction.Transactional;

@Service
public class SchoolServiceImpl implements SchoolService{

	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Override
	public List<SchoolModel> findAll() {
		
		return schoolRepository.findAll();
	}

	@Override
	public Optional<SchoolModel> findById(Long id) {
		
		return schoolRepository.findById(id);
	}

	@Override
	@Transactional
	public SchoolModel save(SchoolModel school) {
		
		return schoolRepository.save(school);
	}

	@Override
	@Transactional
	public void delete(SchoolModel school) {
		
		schoolRepository.delete(school);
		
	}

	@Override
	public boolean existsByName(String name) {
		
		return schoolRepository.existsByName(name);
	}

	@Override
	public boolean existsByCnpj(String cnpj) {
		
		return schoolRepository.existsByCnpj(cnpj);
	}

}
