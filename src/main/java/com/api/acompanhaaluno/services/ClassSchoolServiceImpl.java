package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.projections.ClassJoinMinProjections;
import com.api.acompanhaaluno.repositories.ClassSchoolRepository;
import com.api.acompanhaaluno.repositories.SchoolRepository;

import jakarta.transaction.Transactional;

@Service
public class ClassSchoolServiceImpl implements ClassSchoolService{

	@Autowired
	ClassSchoolRepository classSchoolRepository;
	
	
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
	public boolean existsByName(String name) {
		// TODO Auto-generated method stub
		return classSchoolRepository.existsByName(name);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return classSchoolRepository.existsById(id);
	}

	@Override
	public List<ClassJoinMinProjections> findByAllClassSchool(String schoolName) {
		
		return classSchoolRepository.findByClassSchoolJoin(schoolName);
	}

	

	


	

	
}
