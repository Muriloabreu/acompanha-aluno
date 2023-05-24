package com.api.acompanhaaluno.dtos;

import jakarta.validation.constraints.NotBlank;

public class ClassSchoolDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String category;
	
	/* Constructor */
	
	public ClassSchoolDto() {
		super();
	}

	/* Accessor Methods */
	
	public ClassSchoolDto(@NotBlank String name, @NotBlank String category) {
		super();
		this.name = name;
		this.category = category;
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
	
	
	
	

}
