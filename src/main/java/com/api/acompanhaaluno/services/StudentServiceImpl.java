package com.api.acompanhaaluno.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.acompanhaaluno.models.StudentModel;
import com.api.acompanhaaluno.projections.StudentJoinMinProjection;
import com.api.acompanhaaluno.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<StudentModel> findAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public Optional<StudentModel> findById(Long id) {
	
		return studentRepository.findById(id);
	}

	@Override
	@Transactional
	public StudentModel save(StudentModel student) {
		
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public void delete(StudentModel student) {
		
		studentRepository.delete(student);
	}

	@Override
	public boolean existsByCpf(String cpf) {
		
		return studentRepository.existsByCpf(cpf);
	}

	@Override
	public List<StudentJoinMinProjection> findByListPreStudents(LocalDate date, String name) {
		
		return studentRepository.findByListPreStudents(date, name);
	}

}
