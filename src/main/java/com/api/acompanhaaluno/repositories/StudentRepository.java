package com.api.acompanhaaluno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.acompanhaaluno.models.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Long>{

	boolean existsByCpf(String cpf);
}
