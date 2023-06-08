package com.api.acompanhaaluno.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.api.acompanhaaluno.models.SchoolModel;

public interface SchoolRepository extends JpaRepository<SchoolModel, Long>{

	boolean existsByName(String name);
	boolean existsByCnpj(String cnpj);
	
	
}
