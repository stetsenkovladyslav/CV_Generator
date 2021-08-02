package com.example.producer.dto;

import lombok.*;

@Data
@RequiredArgsConstructor
public class PersonDto {

    private String firstName;

    private String lastName;

    private Integer age;

    private String goal;

    private String experience;

}
