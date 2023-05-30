package com.api.acompanhaaluno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.acompanhaaluno.models.ClassSchoolModel;

public interface ClassSchoolRepository extends JpaRepository<ClassSchoolModel, Long>{

	boolean existsByName(String name);
	boolean existsById(Long id);
}
