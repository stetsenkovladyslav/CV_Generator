package com.example.producer.mapper;


import com.example.producer.dto.PersonDto;
import model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PersonMapper {

    PersonDto toDto(Person person);

    Person dtoToPerson(PersonDto personDto);
}
