package com.example.mapper.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TeacherDto {

    private String name;

    private String email;

    private String category;

    private String about;

    private List<CourseDto> courseList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<CourseDto> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseDto> courseList) {
        this.courseList = courseList;
    }
}
