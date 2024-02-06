package com.example.mapper.service;

import com.example.mapper.dao.entity.TeacherEntity;
import com.example.mapper.dao.repository.TeacherRepository;
import com.example.mapper.mapper.TeacherMapper;
import com.example.mapper.model.dto.TeacherDto;
import com.example.mapper.model.exceptionHandler.NotFoundExceptionHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDto> getAll(){
        List<TeacherEntity> teacherEntity = teacherRepository.findAll();
        return TeacherMapper.INSTANCE.mapToDtos(teacherEntity);
    }

    public TeacherDto findById(Long id){
        TeacherEntity teacherEntity = getElemetById(id);
        return TeacherMapper.INSTANCE.mapToDto(teacherEntity);
    }

    public void add(TeacherDto teacherDto){
        System.out.println("Hello");
        teacherRepository.save(TeacherMapper.INSTANCE.mapToEntity(teacherDto));
    }

    public void edit(TeacherDto teacherDto, Long id) {
        TeacherEntity teacherEntity = TeacherMapper.INSTANCE.buildEntity(teacherDto, getElemetById(id));
        teacherRepository.save(teacherEntity);
    }

    public void delete(String name){
        teacherRepository.delete(teacherRepository
                .findByName(name)
                .orElseThrow(()-> new NotFoundExceptionHandler("Not found")));
    }

    private TeacherEntity getElemetById(Long id){
        return teacherRepository.findById(id)
                .orElseThrow(()-> new NotFoundExceptionHandler("Not Found"));
    }
}
