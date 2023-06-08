package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.projections.ClassJoinMinProjection;


public interface ClassSchoolService {
	
	List<ClassSchoolModel> findAll();
	List<ClassJoinMinProjection>findByClassJoin(String name);
	Optional<ClassSchoolModel> findById(Long id);
	ClassSchoolModel save(ClassSchoolModel classSchool);
	void delete(ClassSchoolModel classSchool);
	boolean existsById(Long id);
}
