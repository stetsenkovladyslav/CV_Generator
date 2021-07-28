package com.example.cv.service.person;


import com.example.cv.dto.PersonDto;
import com.example.cv.mapper.PersonMapper;
import com.example.cv.model.Person;
import com.example.cv.persistence.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Person create(PersonDto personDto) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void updateById(String id, PersonDto personDto) {

    }




}
