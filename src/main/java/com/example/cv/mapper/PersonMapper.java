package com.example.cv.mapper;


import com.example.cv.dto.PersonDto;
import com.example.cv.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PersonMapper {

    PersonDto toDto(Person person);

    Person dtoToPerson(PersonDto personDto);
}
