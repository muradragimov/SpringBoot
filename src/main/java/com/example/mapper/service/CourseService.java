package com.example.mapper.service;

import com.example.mapper.dao.entity.CourseEntity;
import com.example.mapper.dao.repository.CourseRepository;
import com.example.mapper.mapper.CourseMapper;
import com.example.mapper.model.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public int integer = 0;
    public List<Integer> integers = new ArrayList<>();

    public List<CourseDto> getAll(){
        List<CourseEntity> courseEntities = courseRepository.findAll();
        return CourseMapper.INSTANCE.mapToDtos(courseEntities);
    }

    public void add(CourseDto courseDto){
        CourseEntity courseEntity = CourseMapper.INSTANCE.mapToEntity(courseDto);
        courseRepository.save(courseEntity);
    }

    public void run() throws InterruptedException {
        if(integer == 0){
            for (int in=1; in< 1000; in++){
                in = in+1;
            }
            integers.add(5);
            integer++;
        }
        System.out.println(integers);
    }
}
