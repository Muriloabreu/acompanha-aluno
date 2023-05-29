package com.api.acompanhaaluno.dtos;

import com.api.acompanhaaluno.models.ClassSchoolModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentDto {
	
	@NotBlank
	private String firtsName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String cpf;
	@NotBlank
	private String ages;
	@NotBlank
	private String responsibleName;
	@NotNull
	private ClassSchoolModel classSchool;
	
	
	public StudentDto() {
		super();
	}


	public StudentDto(@NotBlank String firtsName, @NotBlank String lastName, @NotBlank String cpf,
			@NotBlank String ages, @NotBlank String responsibleName, @NotNull ClassSchoolModel classSchool) {
		super();
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.ages = ages;
		this.responsibleName = responsibleName;
		this.classSchool = classSchool;
	}


	public String getFirtsName() {
		return firtsName;
	}


	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getAges() {
		return ages;
	}


	public void setAges(String ages) {
		this.ages = ages;
	}


	public String getResponsibleName() {
		return responsibleName;
	}


	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}


	public ClassSchoolModel getClassSchool() {
		return classSchool;
	}


	public void setClassSchool(ClassSchoolModel classSchool) {
		this.classSchool = classSchool;
	}
	
	
	
	

}
