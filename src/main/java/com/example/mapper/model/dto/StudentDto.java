package com.example.mapper.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Builder
@Data
@ApiModel("student")
public class StudentDto {

    @NotBlank
    @ApiModelProperty("name")
    private String name;

    @NotBlank
    @ApiModelProperty("surname")
    private String surname;

    @NotBlank
    @Email(message = "INCORRECT_EMAIL")
    @ApiModelProperty("email")
    private String email;

    @NotBlank
    @Length(min = 8,message = "PASSWORD_LESS_THAN_8_ELEMENTS")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
