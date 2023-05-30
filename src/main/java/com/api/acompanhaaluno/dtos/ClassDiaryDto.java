package com.api.acompanhaaluno.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.api.acompanhaaluno.models.StudentModel;

public class ClassDiaryDto {
	
	
	private List<StudentModel> students = new ArrayList<>();
	
	private LocalDate date; 
	
	private String note;

	public ClassDiaryDto() {
		super();
	}

	public ClassDiaryDto(List<StudentModel> students, LocalDate date, String note) {
		super();
		this.students = students;
		this.date = date;
		this.note = note;
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
	
	

}
