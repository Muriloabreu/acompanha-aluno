package com.api.acompanhaaluno.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.acompanhaaluno.models.StudentModel;
import com.api.acompanhaaluno.projections.StudentJoinMinProjection;

public interface StudentRepository extends JpaRepository<StudentModel, Long>{

	boolean existsByCpf(String cpf);
	
	
	@Query(nativeQuery = true, value = "SELECT cd.date, s.firts_name, s.last_name, cs.name, sch.name, cd.note FROM tb_class_diarys cd "
			+ "INNER JOIN tb_students s ON s.id = cd.student_id "
			+ "INNER JOIN tb_class_schools cs ON s.class_school_id = cs.id "
			+ "INNER JOIN tb_schools sch ON cs.school_id = sch.id "
			+ "WHERE cd.date = :date "
			+ "AND sch.name LIKE %:name% ")
	List<StudentJoinMinProjection> findByListPreStudents(LocalDate date, String name);
}
