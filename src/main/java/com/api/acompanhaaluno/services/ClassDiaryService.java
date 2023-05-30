package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import com.api.acompanhaaluno.models.ClassDiaryModel;

public interface ClassDiaryService {
	
	List<ClassDiaryModel> findAll();
	Optional<ClassDiaryModel> findById(Long id);
	ClassDiaryModel save(ClassDiaryModel classDiary);
	void delete(ClassDiaryModel classDiary);
	
	
}
