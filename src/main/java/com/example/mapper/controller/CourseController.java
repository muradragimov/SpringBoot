package com.example.mapper.controller;


import com.example.mapper.model.dto.CourseDto;
import com.example.mapper.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService studentService;

    public CourseController(CourseService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public List<CourseDto> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/update")
    public void add(@RequestBody @Valid CourseDto courseDto){
        studentService.add(courseDto);
    }
}
