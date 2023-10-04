package com.example.mapper.controller;

import com.example.mapper.dao.entity.CourseEntity;
import com.example.mapper.model.dto.CourseDto;
import com.example.mapper.model.dto.StudentDto;
import com.example.mapper.service.StudentService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<StudentDto> getSorted(@RequestParam String field){
        return studentService.getSorted(field);
    }

    @GetMapping("/")
    public List<StudentDto> getAll(@RequestParam Integer offset, @RequestParam Integer pageSize){
        return studentService.getAll(offset, pageSize);
    }

    @GetMapping("/{id}")
    public StudentDto get(@RequestParam Long id){
        return studentService.getById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody @Valid StudentDto studentDto){
        studentService.add(studentDto);
    }

    @PutMapping("/edit/{courseName}/{student_id}")
    public void edit(@RequestParam String courseName, @RequestParam Long student_id){
        studentService.update(courseName, student_id);
    }

    @DeleteMapping("/delete/{name}")
    public  void delete(@RequestParam String name){
        studentService.delete(name);
    }
}
