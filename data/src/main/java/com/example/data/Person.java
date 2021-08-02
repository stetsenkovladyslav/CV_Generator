package com.example.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cv")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String goal;
    private String experience;

    @PersistenceConstructor
    public Person(String firstName, String lastName, Integer age, String goal, String experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.goal = goal;
        this.experience = experience;
    }

}
