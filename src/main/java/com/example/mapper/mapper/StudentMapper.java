package com.example.mapper.mapper;

import com.example.mapper.dao.entity.StudentEntity;
import com.example.mapper.model.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    List<StudentDto> mapToDto(List<StudentEntity> studentEntity);

    @Mappings(value = {
            @Mapping(target = "id", ignore =true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    StudentEntity mapToEntity(StudentDto studentDto);

    StudentDto mapToDto(StudentEntity studentEntity);
}
