package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import com.api.acompanhaaluno.models.ClassSchoolModel;


public interface ClassSchoolService {
	
	List<ClassSchoolModel> findAll();
	List<ClassSchoolModel>findByNameJoin(String name);
	Optional<ClassSchoolModel> findById(Long id);
	ClassSchoolModel save(ClassSchoolModel classSchool);
	void delete(ClassSchoolModel classSchool);
	boolean existsById(Long id);
}
