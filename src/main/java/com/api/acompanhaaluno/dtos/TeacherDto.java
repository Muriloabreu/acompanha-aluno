package com.api.acompanhaaluno.dtos;

import java.util.List;

import com.api.acompanhaaluno.models.ClassSchoolModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TeacherDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String cpf;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	@NotNull
	List<ClassSchoolModel> classSchools;
	
	public TeacherDto() {
		super();
	}

	public TeacherDto(@NotBlank String name, @NotBlank String cpf, @NotBlank String email, @NotBlank String senha,
			@NotNull List<ClassSchoolModel> classSchools) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.classSchools = classSchools;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<ClassSchoolModel> getClassSchools() {
		return classSchools;
	}

	public void setClassSchools(List<ClassSchoolModel> classSchools) {
		this.classSchools = classSchools;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
