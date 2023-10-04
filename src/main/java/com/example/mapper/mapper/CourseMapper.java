package com.example.mapper.mapper;

import com.example.mapper.dao.entity.CourseEntity;
import com.example.mapper.dao.entity.StudentEntity;
import com.example.mapper.model.dto.CourseDto;
import com.example.mapper.model.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    List<CourseDto> mapToDtos(List<CourseEntity> courseEntity);

    @Mappings(value = {
            @Mapping(target = "id", ignore =true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    CourseEntity mapToEntity(CourseDto courseDto);

    CourseDto mapToDto(CourseEntity courseEntity);
}
