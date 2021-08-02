package com.example.producer.mapper;


import com.example.data.Person;
import com.example.producer.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PersonMapper {

    PersonDto toDto(Person person);

    Person dtoToPerson(PersonDto personDto);
}
