package com.api.acompanhaaluno.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.api.acompanhaaluno.models.ClassSchoolModel;


public interface ClassSchoolRepository extends JpaRepository<ClassSchoolModel, Long>{
	
	
	
	@Query(value = "SELECT c FROM ClassSchoolModel c INNER JOIN SchoolModel s ON c.school_id = s.id "
			+ "WHERE s.name LIKE %_?1% ")
	List<ClassSchoolModel> findByNameJoin(String name);
}
