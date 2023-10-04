package com.example.mapper.controller;


import com.example.mapper.model.dto.CourseDto;
import com.example.mapper.model.dto.StudentDto;
import com.example.mapper.service.CourseService;
import com.example.mapper.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class CourseController implements Runnable{
    @Autowired
    public CourseService studentService;

    @GetMapping("/")
    public List<CourseDto> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/")
    public void add(@RequestBody @Valid CourseDto courseDto){
        studentService.add(courseDto);
    }

    @GetMapping("/get")
    public void run(){
        try {
            studentService.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
