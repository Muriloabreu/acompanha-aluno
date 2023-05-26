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


import com.api.acompanhaaluno.dtos.SchoolDto;
import com.api.acompanhaaluno.models.SchoolModel;
import com.api.acompanhaaluno.services.SchoolService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/acompanha-aluno/Schools") /*Mapeamento a nível de classe*/
public class SchoolController {
	
	@Autowired
	SchoolService schoolService;
	
	@PostMapping
	public ResponseEntity<Object> saveSchool(@RequestBody @Valid SchoolDto SchoolDto){
		
		if (schoolService.existsByName(SchoolDto.getName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name School is already in use!"); 
		}
		if (schoolService.existsByCnpj(SchoolDto.getCnpj())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CNPJ School is already in use!"); 
		}
		SchoolModel SchoolModel = new SchoolModel();
		BeanUtils.copyProperties(SchoolDto, SchoolModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(schoolService.save(SchoolModel));
	}
	
	@GetMapping
	public ResponseEntity<List<SchoolModel>>getAllSchools(){
		return ResponseEntity.status(HttpStatus.OK).body(schoolService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneSchool(@PathVariable(value = "id") Long id) {

		Optional<SchoolModel> SchoolOptional = schoolService.findById(id);

		if (!SchoolOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("School not found. "); /* Mensagem se a School não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(SchoolOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSchool(@PathVariable(value = "id") Long id) {

		Optional<SchoolModel> SchoolOptional = schoolService.findById(id);

		if (!SchoolOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("School not found. "); /* Mensagem se a School não for encontrado */
		}
		
		schoolService.delete(SchoolOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("School deleted successfully.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSchool(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid SchoolDto SchoolDto) {

		Optional<SchoolModel> SchoolOptional = schoolService.findById(id);

		if (!SchoolOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("School not found. "); /* Mensagem se a School não for encontrado */
		}
		
		var SchoolModel = SchoolOptional.get();
		SchoolModel.setName(SchoolDto.getName());
		SchoolModel.setCnpj(SchoolDto.getCnpj());
		SchoolModel.setCity(SchoolDto.getCity());
			
		
		return ResponseEntity.status(HttpStatus.OK).body(schoolService.save(SchoolModel));

	}

}
