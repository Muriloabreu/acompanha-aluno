package com.api.acompanhaaluno.models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_STUDENTS")
public class StudentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firtsName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false, unique = true, length = 15)
	private String cpf;
	@Column(nullable = false)
	private String ages;
	@Column(nullable = false)
	private String responsibleName;
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	@OneToOne
	@JoinColumn(name = "class_school_id", referencedColumnName = "id")
	private ClassSchoolModel classSchool;
	
	/* Constructor */
	
	public StudentModel() {
		
	}
	
	public StudentModel(Long id, String firtsName, String lastName, String cpf, String ages, String responsibleName,
			LocalDateTime registrationDate, ClassSchoolModel classSchool) {
		super();
		this.id = id;
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.ages = ages;
		this.responsibleName = responsibleName;
		this.registrationDate = registrationDate;
		this.classSchool = classSchool;
	}



	/* Accessor Methods */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public ClassSchoolModel getClassSchool() {
		return classSchool;
	}

	public void setClassSchool(ClassSchoolModel classSchool) {
		this.classSchool = classSchool;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", firtsName=" + firtsName + ", lastName=" + lastName + ", cpf=" + cpf
				+ ", ages=" + ages + ", responsibleName=" + responsibleName + ", registrationDate=" + registrationDate
				+ ", classSchool=" + classSchool + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ages, classSchool, cpf, firtsName, id, lastName, registrationDate, responsibleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentModel other = (StudentModel) obj;
		return Objects.equals(ages, other.ages) && Objects.equals(classSchool, other.classSchool)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(firtsName, other.firtsName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(registrationDate, other.registrationDate)
				&& Objects.equals(responsibleName, other.responsibleName);
	}

	
	
	
	
	
	
	
	
}
