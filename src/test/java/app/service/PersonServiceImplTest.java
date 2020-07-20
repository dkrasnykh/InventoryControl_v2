package app.service;

import app.converter.CustomConversionService;
import app.dto.PersonDto;
import app.entity.Person;
import app.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {
    @InjectMocks
    private PersonServiceImpl personService;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private CustomConversionService conversionService;

    @Test
    public void verifyGetPersonByIdFromRepository(){
        Mockito.when(personRepository.findById(any())).thenReturn(Optional.of(new Person()));
        personService.getPersonById(1L);
        Mockito.verify(personRepository).findById(any());
    }

    @Test
    public void testGetPersonByIdPersonNotFound(){
        Mockito.when(personRepository.findById(any())).thenReturn(Optional.empty());
        try{
            personService.getPersonById(1L);
        } catch (RuntimeException ex){
            Assert.assertEquals("Person is not found", ex.getMessage());
        }
    }

    @Test
    public void checkConvertPerson(){
        Person exceptedPerson = new Person();
        PersonDto exceptedPersonDto = new PersonDto();
        Mockito.when(personRepository.findById(any())).thenReturn(Optional.of(exceptedPerson));
        Mockito.when(conversionService.convert(exceptedPerson, PersonDto.class)).thenReturn(exceptedPersonDto);
        PersonDto result = personService.getPersonById(1l);
        Mockito.verify(conversionService).convert(exceptedPerson, PersonDto.class);
        Assert.assertSame(exceptedPersonDto, result);
    }

}
