package com.api.acompanhaaluno.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.api.acompanhaaluno.models.StudentModel;

public class ClassDiaryDto {
	
	
	private StudentModel student;
	
	private LocalDate date; 
	
	private String note;

	public ClassDiaryDto() {
		
	}

	public ClassDiaryDto(StudentModel student, LocalDate date, String note) {
		
		this.student = student;
		this.date = date;
		this.note = note;
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
	
	

}
