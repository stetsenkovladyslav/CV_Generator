package com.example.producer.service.person;


import com.example.data.Person;
import com.example.data.aws.service.AwsFileService;
import com.example.producer.dto.PersonDto;
import com.example.producer.mapper.PersonMapper;
import com.example.producer.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final KafkaTemplate<String, Person> kafkaTemplate;
    private final AwsFileService awsFileService;

    @Override
    public Person create(PersonDto personDto) {
        Person person = personMapper.dtoToPerson(personDto);
        person = personRepository.save(person);
        kafkaTemplate.send("pdf", person);
        return person;
    }

    @Override
    public void deleteById(String id) {
        personRepository.deleteById(id);
        awsFileService.delete(id.concat(".pdf"));
    }

    @Override
    public void updateById(String id, PersonDto personDto) {
        personRepository.findById(id);
        Person updated = personMapper.dtoToPerson(personDto);
        updated = personRepository.save(updated);
        kafkaTemplate.send("pdf", updated);
    }

    @Override
    public InputStreamResource downloadCV(String id) {
        String fileName = id.concat(".pdf");
        return awsFileService.download(fileName);
    }

}
