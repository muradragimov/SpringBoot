package com.example.mapper.controller;

import com.example.mapper.model.dto.CourseDto;
import com.example.mapper.model.dto.StudentDto;
import com.example.mapper.model.dto.TeacherDto;
import com.example.mapper.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public List<TeacherDto> getAll(){
        return teacherService.getAll();
    }

    @PostMapping("/")
    public void add(@RequestBody TeacherDto teacherDto){
        teacherService.add(teacherDto);
    }

    @PutMapping("/edit/{course_id}")
    public void edit(@RequestBody TeacherDto teacherDto, @RequestParam Long student_id){
        teacherService.edit(teacherDto, student_id);
    }

    @DeleteMapping("/delete/{name}")
    public  void delete(@RequestParam String name){
        teacherService.delete(name);
    }

}
