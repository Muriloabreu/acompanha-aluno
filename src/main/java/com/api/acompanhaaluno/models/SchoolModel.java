package com.api.acompanhaaluno.models;


import java.util.Objects;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SCHOOLS")
public class SchoolModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String cnpj;
	@Column(nullable = false)
	private String city;
		
	/* Constructor */
	
	public SchoolModel() {
		
	}

	public SchoolModel(Long id, String name, String cnpj, String city) {
		
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.city = city;
		
	}



	/* Accessor Methods */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "SchoolModel [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, cnpj, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolModel other = (SchoolModel) obj;
		return Objects.equals(city, other.city) && Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
	

	
	
	
	
	

}
