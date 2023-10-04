package com.example.mapper.dao.repository;

import com.example.mapper.dao.entity.TeacherEntity;
import com.example.mapper.model.dto.TeacherDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    Optional<TeacherEntity> findByName(String name);
}
