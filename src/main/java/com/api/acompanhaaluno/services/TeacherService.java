package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import com.api.acompanhaaluno.models.TeacherModel;

public interface TeacherService {

	List<TeacherModel> findAll();
	Optional<TeacherModel> findById(Long id);
	TeacherModel save(TeacherModel teacher);
	void delete(TeacherModel teacher);
	boolean existsByName(String name);
}
