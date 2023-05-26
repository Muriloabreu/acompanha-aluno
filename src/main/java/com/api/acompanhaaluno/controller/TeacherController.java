package com.api.acompanhaaluno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.api.acompanhaaluno.dtos.TeacherDto;
import com.api.acompanhaaluno.models.TeacherModel;
import com.api.acompanhaaluno.services.TeacherService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/acompanha-aluno/teachers") /*Mapeamento a nível de classe*/
public class TeacherController {
	
	
	@Autowired
	TeacherService teacherService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveTeacher(@RequestBody @Valid TeacherDto teacherDto){
		
		if (teacherService.existsByCpf(teacherDto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF for Teacher is already in use!"); 
		}
		
		TeacherModel teacherModel = new TeacherModel();
		BeanUtils.copyProperties(teacherDto, teacherModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacherModel));
	}
	
	@GetMapping
	public ResponseEntity<List<TeacherModel>>getAllTeacher(){
		return ResponseEntity.status(HttpStatus.OK).body(teacherService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTeacher(@PathVariable(value = "id") Long id) {

		Optional<TeacherModel> teacherOptional = teacherService.findById(id);

		if (!teacherOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found. "); /* Mensagem se a School não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(teacherOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTeacher(@PathVariable(value = "id") Long id) {

		Optional<TeacherModel> teacherOptional = teacherService.findById(id);

		if (!teacherOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found. "); /* Mensagem se a School não for encontrado */
		}
		
		teacherService.delete(teacherOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted successfully.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTeacher(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid TeacherDto teacherDto) {

		Optional<TeacherModel> teacherOptional = teacherService.findById(id);

		if (!teacherOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found. "); /* Mensagem se a School não for encontrado */
		}
		
		var teacherModel = teacherOptional.get();
		teacherModel.setName(teacherDto.getName());
		teacherModel.setCpf(teacherDto.getCpf());
		teacherModel.setEmail(teacherDto.getEmail());
		teacherModel.setSenha(teacherDto.getSenha());
			
		
		return ResponseEntity.status(HttpStatus.OK).body(teacherService.save(teacherModel));

	}

}
