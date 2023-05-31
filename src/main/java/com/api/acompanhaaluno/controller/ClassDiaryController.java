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

import com.api.acompanhaaluno.dtos.ClassDiaryDto;
import com.api.acompanhaaluno.models.ClassDiaryModel;
import com.api.acompanhaaluno.services.ClassDiaryService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/acompanha-aluno/classdiarys") /*Mapeamento a nível de classe*/
public class ClassDiaryController {
	
	@Autowired
	ClassDiaryService classDiaryService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveClassDiary(@RequestBody @Valid ClassDiaryDto classDiaryDto){
		
		
		ClassDiaryModel classDiaryModel = new ClassDiaryModel();
		BeanUtils.copyProperties(classDiaryDto, classDiaryModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(classDiaryService.save(classDiaryModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ClassDiaryModel>>getAllClassDiarys(){
		return ResponseEntity.status(HttpStatus.OK).body(classDiaryService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneClassDiary(@PathVariable(value = "id") Long id) {

		Optional<ClassDiaryModel> classDiaryOptional = classDiaryService.findById(id);

		if (!classDiaryOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class Diary not found. "); /* Mensagem se a School não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(classDiaryOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteClassDiary(@PathVariable(value = "id") Long id) {

		Optional<ClassDiaryModel> classDiaryOptional = classDiaryService.findById(id);

		if (!classDiaryOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class Diary not found. "); /* Mensagem se a School não for encontrado */
		}
		
		classDiaryService.delete(classDiaryOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Class Diary deleted successfully.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateClassDiary(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid ClassDiaryDto classDiaryDto) {

		Optional<ClassDiaryModel> classDiaryOptional = classDiaryService.findById(id);

		if (!classDiaryOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class Diary not found. "); /* Mensagem se a School não for encontrado */
		}
		
		var classDiaryModel = classDiaryOptional.get();
		classDiaryModel.setStudent(classDiaryDto.getStudent());
		classDiaryModel.setDate(classDiaryDto.getDate());
		classDiaryModel.setNote(classDiaryDto.getNote());
			
		
		return ResponseEntity.status(HttpStatus.OK).body(classDiaryService.save(classDiaryModel));

	}

}
