package com.api.acompanhaaluno.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	@OneToMany
	@JoinColumn(name = "school_id")
	private List<ClassSchoolModel> classSchools = new ArrayList<>();
	
	
	/* Constructor */
	
	public SchoolModel() {
		
	}

	public SchoolModel(Long id, String name, String cnpj, String city, List<ClassSchoolModel> classSchools) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.city = city;
		this.classSchools = classSchools;
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
	
	public List<ClassSchoolModel> getClassSchols() {
		return classSchools;
	}
	
	public void setClassSchols(List<ClassSchoolModel> classSchols) {
		this.classSchools = classSchols;
	}

	@Override
	public String toString() {
		return "SchoolModel [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", city=" + city + ", classSchols="
				+ classSchools + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, classSchools, cnpj, id, name);
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
		return Objects.equals(city, other.city) && Objects.equals(classSchools, other.classSchools)
				&& Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
	

}
