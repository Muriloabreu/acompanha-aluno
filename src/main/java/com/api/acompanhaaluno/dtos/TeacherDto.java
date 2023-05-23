package com.api.acompanhaaluno.dtos;

import java.util.List;

import com.api.acompanhaaluno.models.SchoolModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TeacherDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String cpf;
	@NotNull
	List<SchoolModel> schools;
	
	public TeacherDto() {
		super();
	}

	public TeacherDto(@NotBlank String name, @NotBlank String cpf, @NotNull List<SchoolModel> schools) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.schools = schools;
	}
	
	
	

}
