package com.api.acompanhaaluno.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.services.ClassSchoolService;


import jakarta.validation.Valid;


@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/acompanha-aluno/classSchools") /*Mapeamento a nível de classe*/
public class ClassSchoolController {
	
	
	@Autowired
	ClassSchoolService classSchoolService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveClassSchool(@RequestBody @Valid ClassSchoolDto classSchoolDto){
		
		if (classSchoolService.existsByName(classSchoolDto.getName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name ClassSchool is already in use!"); 
		}
		ClassSchoolModel classSchoolModel = new ClassSchoolModel();
		BeanUtils.copyProperties(classSchoolDto, classSchoolModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(classSchoolService.save(classSchoolModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ClassSchoolModel>>getAllClassSchools(){
		return ResponseEntity.status(HttpStatus.OK).body(classSchoolService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") Long id) {

		Optional<ClassSchoolModel> classSchoolOptional = classSchoolService.findById(id);

		if (!classSchoolOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClassSchool not found. "); /*Mensagem se o cliente não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(classSchoolOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteClassSchool(@PathVariable(value = "id") Long id) {

		Optional<ClassSchoolModel> classSchoolOptional = classSchoolService.findById(id);

		if (!classSchoolOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClassSchool not found. "); 
			}
		
		classSchoolService.delete(classSchoolOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("ClassSchool deleted successfully.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid ClassSchoolDto classSchoolDto) {

		Optional<ClassSchoolModel> classSchoolOptional = classSchoolService.findById(id);

		if (!classSchoolOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClassSchool not found. "); 
			}
		
		var classSchoolModel = classSchoolOptional.get();
		classSchoolModel.setName(classSchoolDto.getName());
		classSchoolModel.setCategory(classSchoolDto.getCategory());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(classSchoolService.save(classSchoolModel));

	}

}
