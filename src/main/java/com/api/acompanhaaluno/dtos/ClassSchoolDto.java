package com.api.acompanhaaluno.dtos;

import com.api.acompanhaaluno.models.SchoolModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClassSchoolDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String category;
	@NotNull
	private SchoolModel school;
	
	/* Constructor */
	
	public ClassSchoolDto() {
		super();
	}

	/* Accessor Methods */
	
	public ClassSchoolDto(@NotBlank String name, @NotBlank String category, @NotNull SchoolModel school ) {
		super();
		this.name = name;
		this.category = category;
		this.school = school;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	public SchoolModel getSchool() {
		return school;
	}
	public void setSchool(SchoolModel school) {
		this.school = school;
	}
	
	

}
