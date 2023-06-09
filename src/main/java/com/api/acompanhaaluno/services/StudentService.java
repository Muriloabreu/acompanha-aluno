package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import com.api.acompanhaaluno.models.StudentModel;
import com.api.acompanhaaluno.projections.StudentJoinMinProjection;

public interface StudentService {
	
	List<StudentModel> findAll();
	List<StudentJoinMinProjection>findByListPreStudents(String date, String name);
	Optional<StudentModel> findById(Long id);
	StudentModel save(StudentModel student);
	void delete(StudentModel student);
	boolean existsByCpf(String cpf);

}
