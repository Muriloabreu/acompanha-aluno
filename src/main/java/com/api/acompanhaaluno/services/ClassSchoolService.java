package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.projections.ClassJoinMinProjections;

public interface ClassSchoolService {
	
	List<ClassSchoolModel> findAll();
	List<ClassJoinMinProjections>findByAllClassSchool(String schoolName);
	Optional<ClassSchoolModel> findById(Long id);
	ClassSchoolModel save(ClassSchoolModel classSchool);
	void delete(ClassSchoolModel classSchool);
	boolean existsByName(String name);
	boolean existsById(Long id);
}
