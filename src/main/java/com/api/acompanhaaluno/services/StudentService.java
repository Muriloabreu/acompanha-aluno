package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import com.api.acompanhaaluno.models.StudentModel;

public interface StudentService {
	
	List<StudentModel> findAll();
	Optional<StudentModel> findById(Long id);
	StudentModel save(StudentModel student);
	void delete(StudentModel student);
	boolean existsByCpf(String cpf);

}
