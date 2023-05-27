package com.api.acompanhaaluno.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(nullable = false)
	private String ages;
	@Column(nullable = false)
	private String responsibleName;
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	
	
}
