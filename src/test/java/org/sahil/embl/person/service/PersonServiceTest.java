package org.sahil.embl.person.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.sahil.embl.person.exception.NotFoundException;
import org.sahil.embl.person.factory.PersonFactory;
import org.sahil.embl.person.model.Person;
import org.sahil.embl.person.model.PersonDAO;
import org.sahil.embl.person.model.PersonDetails;
import org.sahil.embl.person.model.Persons;
import org.sahil.embl.person.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonFactory personFactory;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void createPerson() {
        Person person = mock(Person.class);
        PersonDAO personDAO = mock(PersonDAO.class);
        PersonDAO savedPerson = mock(PersonDAO.class);
        PersonDetails personDetails = mock(PersonDetails.class);

        when(personFactory.translatePerson(person)).thenReturn(personDAO);
        when(personRepository.save(personDAO)).thenReturn(savedPerson);
        when(personFactory.translatePersonDao(savedPerson)).thenReturn(personDetails);

        PersonDetails actual = personService.createPerson(person);

        assertThat(actual).isEqualTo(personDetails);
    }

    @Test
    public void deletePerson() {
        Long personId = someLong();
        PersonDAO personDAO = mock(PersonDAO.class);

        when(personRepository.findById(personId)).thenReturn(Optional.of(personDAO));

        personService.deletePerson(personId);

        verify(personRepository, times(1)).deleteById(personId);
    }

    @Test(expected = NotFoundException.class)
    public void deletePerson_not_found() {
        Long personId = someLong();

        when(personRepository.findById(personId)).thenReturn(Optional.empty());

        personService.deletePerson(personId);

        verify(personRepository, times(0)).deleteById(personId);
    }

    @Test
    public void fetchAllPersons() {
        List<PersonDAO> personDAOList = new ArrayList<>();
        PersonDAO personDAO = mock(PersonDAO.class);
        personDAOList.add(personDAO);
        PersonDetails personDetails = mock(PersonDetails.class);

        when(personRepository.findAll()).thenReturn(personDAOList);
        when(personFactory.translatePersonDao(personDAO)).thenReturn(personDetails);

        Persons actual = personService.fetchAllPersons();

        assertThat(actual.getPerson().size()).isEqualTo(1);
    }

    @Test
    public void fetchAllPersons_no_person() {
        List<PersonDAO> personDAOList = new ArrayList<>();

        when(personRepository.findAll()).thenReturn(personDAOList);

        Persons actual = personService.fetchAllPersons();

        assertThat(actual.getPerson().size()).isEqualTo(0);
    }

    @Test
    public void fetchPerson() {
        Long personId = someLong();
        PersonDAO personDAO = mock(PersonDAO.class);
        PersonDetails person = mock(PersonDetails.class);

        when(personRepository.findById(personId)).thenReturn(Optional.of(personDAO));
        when(personFactory.translatePersonDao(personDAO)).thenReturn(person);

        Person actual = personService.fetchPerson(personId);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(person);
    }

    @Test(expected = NotFoundException.class)
    public void fetchPerson_not_found() {
        Long personId = someLong();

        when(personRepository.findById(personId)).thenReturn(Optional.empty());

        personService.fetchPerson(personId);
    }

    @Test(expected = NotFoundException.class)
    public void updatePerson_not_found() {
        Long personId = someLong();
        Person person = mock(Person.class);

        when(personRepository.findById(personId)).thenReturn(Optional.empty());

        personService.updatePerson(personId, person);

        verify(personRepository, times(0)).save(any());

    }

    @Test
    public void updatePerson() {
        Long personId = someLong();
        Person person = mock(Person.class);
        PersonDAO personDAO = mock(PersonDAO.class);

        when(personRepository.findById(personId)).thenReturn(Optional.of(personDAO));

        personService.updatePerson(personId, person);

        verify(personRepository, times(1)).save(personDAO);
    }
}