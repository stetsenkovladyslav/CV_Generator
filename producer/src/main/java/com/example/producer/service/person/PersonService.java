package com.example.producer.service.person;

import com.example.producer.dto.PersonDto;
import model.Person;
import org.springframework.core.io.InputStreamResource;

public interface PersonService {


    Person create(PersonDto personDto);

    void deleteById(String id);

    void updateById(String id, PersonDto personDto);

    InputStreamResource downloadCV(String id);


}
