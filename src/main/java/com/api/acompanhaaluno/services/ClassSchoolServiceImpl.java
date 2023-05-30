package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.repositories.ClassSchoolRepository;
import com.api.acompanhaaluno.repositories.SchoolRepository;

import jakarta.transaction.Transactional;

@Service
public class ClassSchoolServiceImpl implements ClassSchoolService{

	@Autowired
	ClassSchoolRepository classSchoolRepository;
	@Autowired
	SchoolRepository schoolRepository;
	
	@Override
	public List<ClassSchoolModel> findAll() {
		
		return classSchoolRepository.findAll();
	}

	@Override
	public Optional<ClassSchoolModel> findById(Long id) {
		
		return classSchoolRepository.findById(id);
	}

	@Override
	@Transactional
	public ClassSchoolModel save(ClassSchoolModel classSchool) {
		
		return classSchoolRepository.save(classSchool);
	}

	@Override
	@Transactional
	public void delete(ClassSchoolModel classSchool) {
		
		classSchoolRepository.delete(classSchool);
	}

	@Override
	public boolean existsByName(String Name) {
		
		return classSchoolRepository.existsByName(Name);
	}

	@Override
	public boolean existsById(Long id) {
		
		return schoolRepository.existsById(id);
	}

}
