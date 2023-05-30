package com.api.acompanhaaluno.models;

import java.time.LocalDate;
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
@Table(name = "TB_CLASS_DIARYS")
public class ClassDiaryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany
	@JoinColumn(name = "class_diarys_id")
	private List<StudentModel> students = new ArrayList<>();
	@Column(nullable = false)
	private LocalDate date; 
	@Column(nullable = false)
	private String note;
	
	
	public ClassDiaryModel() {
		super();
	}


	public ClassDiaryModel(Long id, List<StudentModel> students, LocalDate date, String note) {
		super();
		this.id = id;
		this.students = students;
		this.date = date;
		this.note = note;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<StudentModel> getStudents() {
		return students;
	}


	public void setStudents(List<StudentModel> students) {
		this.students = students;
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
		return "ClassDiaryModel [id=" + id + ", students=" + students + ", date=" + date + ", note=" + note + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(date, id, note, students);
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
				&& Objects.equals(students, other.students);
	}
	
	
	

}
