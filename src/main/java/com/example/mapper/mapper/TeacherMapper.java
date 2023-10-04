package com.example.mapper.mapper;

import com.example.mapper.dao.entity.TeacherEntity;
import com.example.mapper.model.dto.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    List<TeacherDto> mapToDtos(List<TeacherEntity> teacherEntities);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "joinedAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    TeacherEntity mapToEntity(TeacherDto teacherDto);

    TeacherDto mapToDto(TeacherEntity teacherEntity);

    default TeacherEntity buildEntity(TeacherDto teacherDto, TeacherEntity teacherEntity){

        teacherEntity.setName(teacherDto.getName());
        teacherEntity.setEmail(teacherDto.getEmail());
        teacherEntity.setAbout(teacherDto.getAbout());
        teacherEntity.setCourseList(teacherDto.getCourseList()
                .stream()
                .map(CourseMapper.INSTANCE::mapToEntity)
                .collect(Collectors.toList()));

        return teacherEntity;
    }
}
