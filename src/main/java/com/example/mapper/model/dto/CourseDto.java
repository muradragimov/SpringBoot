package com.example.mapper.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourseDto {

    private String name;

    private String category;

    private Float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
