package com.example.mapper.dao.repository;

import com.example.mapper.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRespository extends JpaRepository<StudentEntity, Long> {
    boolean existsByEmail(String email);
    Optional<StudentEntity> getStudentEntityByName(String name);
    void deleteByName(String name);
}
