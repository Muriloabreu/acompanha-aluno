package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import com.api.acompanhaaluno.models.SchoolModel;

public interface SchoolService {
	
	List<SchoolModel> findAll();
	Optional<SchoolModel>findById(Long id);
	SchoolModel save(SchoolModel school);
	void delete(SchoolModel school);	
	boolean existsByName(String name);
	boolean existsByCnpj(String cnpj);

}
