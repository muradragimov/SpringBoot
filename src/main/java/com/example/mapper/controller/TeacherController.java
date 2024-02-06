package com.example.mapper.controller;

import com.example.mapper.model.dto.TeacherDto;
import com.example.mapper.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/get")
    public List<TeacherDto> getAll(){
        return teacherService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody TeacherDto teacherDto){
        teacherService.add(teacherDto);
    }

    @PutMapping("/update/{teacher_id}")
    public void edit(@RequestBody TeacherDto teacherDto, @RequestParam Long teacher_id){
        teacherService.edit(teacherDto, teacher_id);
    }

    @DeleteMapping("/delete/{name}")
    public  void delete(@RequestParam String name){
        teacherService.delete(name);
    }
}
