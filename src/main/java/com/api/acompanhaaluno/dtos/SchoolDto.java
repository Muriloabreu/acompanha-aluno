package com.api.acompanhaaluno.dtos;



import jakarta.validation.constraints.NotBlank;


public class SchoolDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String cnpj;
	@NotBlank
	private String city;
	
	
	
	/* Constructor */
	
	public SchoolDto() {
		
	}

	public SchoolDto(@NotBlank String name, @NotBlank String cnpj, @NotBlank String city) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.city = city;
		
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

	
	
	
	
	

}
