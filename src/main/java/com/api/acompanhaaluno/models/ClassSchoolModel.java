package com.api.acompanhaaluno.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CLASS_SCHOOLS")
public class ClassSchoolModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String category;
	@ManyToMany(mappedBy = "classSchools")
	private List<SchoolModel> schools = new ArrayList<>();
	
	/* Constructor */
	
	public ClassSchoolModel() {
		
	}

	public ClassSchoolModel(Long id, String name, String category, List<SchoolModel> schools) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.schools = schools;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public List<SchoolModel> getSchools() {
		return schools;
	}
	public void setSchools(List<SchoolModel> schools) {
		this.schools = schools;
	}

	@Override
	public String toString() {
		return "ClassSchoolModel [id=" + id + ", name=" + name + ", category=" + category + ", schools=" + schools
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, schools);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassSchoolModel other = (ClassSchoolModel) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(schools, other.schools);
	}

	
	
	

}
