package com.api.acompanhaaluno.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.projections.ClassJoinMinProjection;

@Repository
public interface ClassSchoolRepository extends JpaRepository<ClassSchoolModel, Long>{
	
	boolean existsByName(String name);
	
	@Query(nativeQuery = true, value = "SELECT c.category, c.name AS nameClass "
			+ "FROM tb_class_schools c INNER JOIN tb_schools s ON s.id = c.school_id "
			+ "WHERE s.name LIKE %?1% ")
	List<ClassJoinMinProjection> findByClassJoin(String name);
	
}
