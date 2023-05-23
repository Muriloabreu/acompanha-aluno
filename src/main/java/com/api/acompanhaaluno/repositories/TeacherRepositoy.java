package com.api.acompanhaaluno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.acompanhaaluno.models.TeacherModel;

public interface TeacherRepositoy extends JpaRepository<TeacherModel, Long>{
	
	boolean existsByName(String Name);
}
