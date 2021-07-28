package com.example.cv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "cv")
public class PersonDto {

    @NotBlank(message = "FirstName field must not be empty")
    private String firstName;

    @NotBlank(message = "LastName field must not be empty")
    private String lastName;

    @NotBlank(message = "Age must be over 18")
    private Integer age;

    @NotBlank(message = "Goal field must not be empty")
    private String goal;

    @NotBlank(message = "Experience field must not be empty")
    private String experience;

}
