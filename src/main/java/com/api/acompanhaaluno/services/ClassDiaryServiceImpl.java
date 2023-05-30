package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.acompanhaaluno.models.ClassDiaryModel;
import com.api.acompanhaaluno.repositories.ClassDiaryRepository;

import jakarta.transaction.Transactional;

@Service
public class ClassDiaryServiceImpl implements ClassDiaryService{
	
	@Autowired
	ClassDiaryRepository classDiaryRepository;

	@Override
	public List<ClassDiaryModel> findAll() {
		
		return classDiaryRepository.findAll();
	}

	@Override
	public Optional<ClassDiaryModel> findById(Long id) {
		
		return classDiaryRepository.findById(id);
	}

	@Override
	@Transactional
	public ClassDiaryModel save(ClassDiaryModel classDiary) {
		
		return classDiaryRepository.save(classDiary);
	}

	@Override
	@Transactional
	public void delete(ClassDiaryModel classDiary) {
		
		classDiaryRepository.delete(classDiary);
		
	}

}
