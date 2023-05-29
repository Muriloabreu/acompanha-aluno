package com.api.acompanhaaluno.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
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

import com.api.acompanhaaluno.dtos.ClassSchoolDto;
import com.api.acompanhaaluno.dtos.StudentDto;
import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.models.StudentModel;
import com.api.acompanhaaluno.services.StudentService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/acompanha-aluno/students") /*Mapeamento a nível de classe*/
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveStudent(@RequestBody @Valid StudentDto studentDto){
		
		if (studentService.existsByCpf(studentDto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF Student is already in use!"); 
		}
		StudentModel studentModel = new StudentModel();
		BeanUtils.copyProperties(studentDto, studentModel); /*Coverte Dtos para Model*/
		studentModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentModel));
	}
	
	@GetMapping
	public ResponseEntity<List<StudentModel>>getAllStudent(){
		return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneStudent(@PathVariable(value = "id") Long id) {

		Optional<StudentModel> studentOptional = studentService.findById(id);

		if (!studentOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found. "); /*Mensagem se o cliente não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(studentOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable(value = "id") Long id) {

		Optional<StudentModel> studentOptional = studentService.findById(id);

		if (!studentOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found. "); /*Mensagem se o cliente não for encontrado */
		}
		
		studentService.delete(studentOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateClassSchool(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid StudentDto studentDto) {

		Optional<StudentModel> studentOptional = studentService.findById(id);

		if (!studentOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found. "); /*Mensagem se o cliente não for encontrado */
		}
		
		var studentModel = studentOptional.get();
		studentModel.setFirtsName(studentDto.getFirtsName());
		studentModel.setLastName(studentDto.getLastName());
		studentModel.setCpf(studentDto.getCpf());
		studentModel.setAges(studentDto.getAges());
		studentModel.setResponsibleName(studentDto.getResponsibleName());
		studentModel.setClassSchool(studentDto.getClassSchool());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(studentService.save(studentModel));

	}

}
