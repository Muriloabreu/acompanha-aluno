package com.api.acompanhaaluno.dtos;


import java.util.List;

import com.api.acompanhaaluno.models.ClassSchoolModel;

import jakarta.validation.constraints.NotBlank;

public class SchoolDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String cnpj;
	@NotBlank
	private String city;
	@NotBlank
	private List<ClassSchoolModel> classSchools;
	
	
	/* Constructor */
	
	public SchoolDto() {
		
	}

	public SchoolDto(@NotBlank String name, @NotBlank String cnpj, @NotBlank String city,
			@NotBlank List<ClassSchoolModel> classSchools) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.city = city;
		this.classSchools = classSchools;
	}

	/* Accessor Methods */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<ClassSchoolModel> getClassSchools() {
		return classSchools;
	}

	public void setClassSchools(List<ClassSchoolModel> classSchools) {
		this.classSchools = classSchools;
	}
	
	
	
	

}
