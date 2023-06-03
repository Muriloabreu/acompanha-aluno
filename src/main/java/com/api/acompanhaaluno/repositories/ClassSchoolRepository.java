package com.api.acompanhaaluno.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.projections.ClassJoinMinProjections;

public interface ClassSchoolRepository extends JpaRepository<ClassSchoolModel, Long>{
	
	boolean existsByName(String name);
	
	@Query(nativeQuery = true, value = "SELECT  tb_class_schools.name, tb_class_schools.category "
			+ "FROM tb_class_schools "
			+ "INNER JOIN tb_schools ON tb_class_schools.school_id = tb_schools.id "
			+ "WHERE UPPER(tb_schools.name) = UPPER(:schoolName) ")
	List<ClassJoinMinProjections> finByClassSchoolJoin(String schoolName);
}
