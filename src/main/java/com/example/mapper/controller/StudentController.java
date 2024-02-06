package com.example.mapper.controller;

import com.example.mapper.model.dto.StudentDto;
import com.example.mapper.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getList")
    public List<StudentDto> getSorted(@RequestParam String field){
        return studentService.getSorted(field);
    }

    @GetMapping("/get")
    public List<StudentDto> getAll(@RequestParam Integer offset, @RequestParam Integer pageSize){
        return studentService.getAll(offset, pageSize);
    }

    @GetMapping("/get/{id}")
    public StudentDto get(@RequestParam Long id){
        return studentService.getById(id);
    }

    @PostMapping("/add")
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
