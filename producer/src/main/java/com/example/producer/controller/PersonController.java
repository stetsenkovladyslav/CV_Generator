package com.example.producer.controller;

import com.example.data.Person;
import com.example.producer.dto.PersonDto;
import com.example.producer.mapper.PersonMapper;
import com.example.producer.service.person.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.io.IOException;


@AllArgsConstructor
@RestController
public class PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @PostMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<PersonDto> create(@RequestBody @Valid PersonDto authorDto) {
        Person newPerson = personService.create(authorDto);
        return ResponseEntity.ok(personMapper.toDto(newPerson));
    }

    @PatchMapping(
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<?> updatePerson(
            @PathVariable @Valid @Positive(message = "Value must be higher than 0") String id,
            @RequestBody @Valid PersonDto personDto
    ) throws IOException {
        personService.updateById(id, personDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    ResponseEntity<?> deletePerson(
            @PathVariable @Valid @Positive(message = "Value must be higher than 0") String id
    ) {
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/download/{id}", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> download(@PathVariable String id) throws IOException {
        return ResponseEntity.ok()
                .header("Content-disposition", "attachment; fileName=" + id + ".pdf")
                .body(personService.downloadCV(id));
    }

}
