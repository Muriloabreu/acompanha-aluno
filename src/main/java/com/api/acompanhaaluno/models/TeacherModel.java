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
@Table(name = "TB_TEACHER")
public class TeacherModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true, length = 15)
	private String cpf;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String senha;
	@OneToMany
	@JoinColumn(name = "teacher_id")
	private List<ClassSchoolModel> classSchools = new ArrayList<>();
	
	/* Constructor */
	
	public TeacherModel() {
		
	}

	public TeacherModel(Long id, String name, String cpf, String email, String senha,
			List<ClassSchoolModel> classSchools) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
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

	@Override
	public String toString() {
		return "TeacherModel [id=" + id + ", name=" + name + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
				+ ", classSchools=" + classSchools + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(classSchools, cpf, email, id, name, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherModel other = (TeacherModel) obj;
		return Objects.equals(classSchools, other.classSchools) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(senha, other.senha);
	}

	
	

	

	
	
	
	
	
	
	

}
