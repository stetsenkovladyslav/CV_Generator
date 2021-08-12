package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
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


}
