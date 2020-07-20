package app.controller;

import app.dto.PersonDto;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public PersonDto getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<PersonDto> getAll() {
        return personService.getAll();
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @PutMapping
    public PersonDto updatePerson(@RequestBody PersonDto personDto) {
        return personService.updatePerson(personDto);
    }

    @DeleteMapping
    public void deletePerson(@PathParam("id") Long id) {
        personService.deletePerson(id);
    }

}
