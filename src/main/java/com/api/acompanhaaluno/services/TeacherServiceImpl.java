package com.api.acompanhaaluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.acompanhaaluno.models.TeacherModel;
import com.api.acompanhaaluno.repositories.TeacherRepositoy;

import jakarta.transaction.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherRepositoy teacherRepositoy;

	@Override
	public List<TeacherModel> findAll() {
		
		return teacherRepositoy.findAll();
	}

	@Override
	public Optional<TeacherModel> findById(Long id) {
		
		return teacherRepositoy.findById(id);
	}

	@Override
	@Transactional
	public TeacherModel save(TeacherModel teacher) {
		
		return teacherRepositoy.save(teacher);
	}

	@Override
	@Transactional
	public void delete(TeacherModel teacher) {
		
		teacherRepositoy.delete(teacher);
	}

	@Override
	public boolean existsByCpf(String cpf) {
		
		return teacherRepositoy.existsByCpf(cpf);
	}

}
