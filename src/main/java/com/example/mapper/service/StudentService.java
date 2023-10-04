package com.example.mapper.service;

import com.example.mapper.dao.entity.CourseEntity;
import com.example.mapper.dao.entity.StudentEntity;
import com.example.mapper.dao.repository.CourseRepository;
import com.example.mapper.dao.repository.StudentRespository;
import com.example.mapper.mapper.StudentMapper;
import com.example.mapper.model.dto.CourseDto;
import com.example.mapper.model.dto.StudentDto;
import com.example.mapper.model.exceptionHandler.NotFoundExceptionHandler;
import com.example.mapper.model.exceptionHandler.UserAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRespository studentRespository;

    @Autowired
    private CourseRepository courseRepository;

    public List<StudentDto> getSorted(String field){
        List<StudentEntity> studentEntities = studentRespository.findAll(Sort.by(Sort.Direction.DESC, field));
        return StudentMapper.INSTANCE.mapToDto(studentEntities);
    }

    public List<StudentDto> getAll(Integer offset, Integer pageSize){
        Page<StudentEntity> studentPages = studentRespository.findAll(PageRequest.of(offset, pageSize));
        List<StudentEntity> studentEntities = studentPages.stream().collect(Collectors.toList());
        return StudentMapper.INSTANCE.mapToDto(studentEntities);
    }

    public StudentDto getById(Long id){
        StudentEntity student = studentRespository.getReferenceById(id);
        return StudentMapper.INSTANCE.mapToDto(student);
    }

    public String authenticateStudent(StudentDto studentDto) throws Exception{
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Optional<StudentEntity> student = studentRespository.getStudentEntityByName(studentDto.getName());
        if(student.isPresent()){
            if(bCryptPasswordEncoder.matches(student.get().getPassword(), studentDto.getPassword()))
                return "Authenticated";
            else
                return "Not authenticated";
        }
        else throw new NotFoundExceptionHandler("Not found this User");
    }

    public void add(StudentDto studentDto){
        StudentEntity studentEntity = StudentMapper.INSTANCE.mapToEntity(studentDto);
        if(studentRespository.existsByEmail(studentDto.getEmail())){
            throw new UserAlreadyExists(studentDto.getEmail());
        }
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        studentEntity.setPassword(bCrypt.encode(studentEntity.getPassword()));
        studentRespository.save(studentEntity);
    }

    public void update(String courseName, Long id){
        StudentEntity studentEntity = getStudentById(id);
        Optional<CourseEntity> optional = courseRepository.findByName(courseName);
        if(optional.isPresent()){
            studentEntity.getCourses().add(optional.get());
        }
        else optional.orElseThrow(()-> new NotFoundExceptionHandler("Not found " + courseName));
            studentRespository.save(studentEntity);
    }

    public void delete(String name){
        StudentEntity studentEntity = studentRespository.getStudentEntityByName(name)
                .orElseThrow(()-> new NoSuchElementException());
        studentRespository.deleteByName(studentEntity.getName());
    }

    private StudentEntity getStudentById(Long id){
        return studentRespository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Not found"));
    }
}
