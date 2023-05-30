package com.api.acompanhaaluno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.acompanhaaluno.models.ClassDiaryModel;

public interface ClassDiaryRepository extends JpaRepository<ClassDiaryModel, Long>{

}
