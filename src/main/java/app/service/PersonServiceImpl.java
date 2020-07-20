package app.service;

import app.converter.CustomConversionService;
import app.dto.PersonDto;
import app.entity.Person;
import app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, CustomConversionService conversionService) {
        this.personRepository = personRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person is not found"));
        return conversionService.convert(person, PersonDto.class);
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> people = personRepository.findAll();
        return people.stream().map(person -> conversionService.convert(person, PersonDto.class)).collect(Collectors.toList());
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = conversionService.convert(personDto, Person.class);
        return conversionService.convert(personRepository.save(person), PersonDto.class);
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        Person person = personRepository.findById(personDto.getId()).orElseThrow(()->new RuntimeException("Person is not found"));
        person.setLastName(personDto.getLastName());
        person.setFirstName(personDto.getFirstName());
        person.setEmail(personDto.getEmail());
        return conversionService.convert(personRepository.save(person), PersonDto.class);
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(()->new RuntimeException("Person is not found"));
        personRepository.delete(person);
    }
}
