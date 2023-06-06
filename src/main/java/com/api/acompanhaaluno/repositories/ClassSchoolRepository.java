package com.api.acompanhaaluno.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.acompanhaaluno.models.ClassSchoolModel;


public interface ClassSchoolRepository extends JpaRepository<ClassSchoolModel, Long>{
	
	boolean existsByName(String name);
	
	@Query(value = "SELECT  tb_class_schools.name, tb_class_schools.category FROM tb_class_schools"
			+ " INNER JOIN tb_schools ON tb_class_schools.school_id = tb_schools.id "
			+ "WHERE tb_schools.name LIKE %_?1% ", nativeQuery = true)
	List<ClassSchoolModel> findByClassSchoolJoin(String name);
}
