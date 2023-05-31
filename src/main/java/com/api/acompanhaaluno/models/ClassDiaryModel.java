package com.api.acompanhaaluno.models;

import java.time.LocalDate;

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
@Table(name = "TB_CLASS_DIARYS")
public class ClassDiaryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private StudentModel student;
	@Column(nullable = false)
	private LocalDate date; 
	@Column(nullable = false)
	private String note;
	
	
	public ClassDiaryModel() {
		super();
	}


	public ClassDiaryModel(Long id, StudentModel student, LocalDate date, String note) {
		super();
		this.id = id;
		this.student = student;
		this.date = date;
		this.note = note;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public StudentModel getStudent() {
		return student;
	}


	public void setStudent(StudentModel student) {
		this.student = student;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "ClassDiaryModel [id=" + id + ", student=" + student + ", date=" + date + ", note=" + note + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(date, id, note, student);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassDiaryModel other = (ClassDiaryModel) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id) && Objects.equals(note, other.note)
				&& Objects.equals(student, other.student);
	}
	
	
	

}
