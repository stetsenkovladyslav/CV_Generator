package com.example.cv.service.person;

import com.example.cv.dto.PersonDto;
import com.example.cv.model.Person;

public interface PersonService {

    public Person create(PersonDto personDto);
    void  deleteById(String id);
    void  updateById(String id, PersonDto personDto);
    /*TODO
    *  download
    * */
}
