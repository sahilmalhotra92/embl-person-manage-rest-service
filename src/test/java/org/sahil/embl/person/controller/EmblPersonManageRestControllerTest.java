package org.sahil.embl.person.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.sahil.embl.person.model.Person;
import org.sahil.embl.person.model.PersonDetails;
import org.sahil.embl.person.model.Persons;
import org.sahil.embl.person.service.PersonService;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

@RunWith(MockitoJUnitRunner.class)
public class EmblPersonManageRestControllerTest {

    @InjectMocks
    private EmblPersonManageRestController emblPersonManageRest;

    @Mock
    private PersonService personService;

    /**
     * create person
     */
    @Test
    public void createPersonTest() {
        Person person = mock(Person.class);
        PersonDetails personDetails = mock(PersonDetails.class);

        when(personService.createPerson(person)).thenReturn(personDetails);

        ResponseEntity<PersonDetails> actual = emblPersonManageRest.createPerson(person);

        assertThat(actual.getBody()).isEqualTo(personDetails);
        assertThat(actual.getStatusCodeValue()).isEqualTo(201);
    }

    /**
     * delete person by personId
     */
    @Test
    public void deletePersonTest() {
        Long personId = someLong();

        emblPersonManageRest.deletePerson(personId);

        verify(personService, times(1)).deletePerson(personId);
    }

    /**
     * fetch all the persons
     */
    @Test
    public void fetchAllPersonsTest() {
        ResponseEntity<Persons> actual = emblPersonManageRest.fetchAllPersons();

        assertThat(actual.getStatusCodeValue()).isEqualTo(200);
        verify(personService, times(1)).fetchAllPersons();
    }

    /**
     * fetch person by personId
     */
    @Test
    public void fetchPersonTest() {
        Long personId = someLong();
        Person person = mock(Person.class);

        when(personService.fetchPerson(personId)).thenReturn(person);

        ResponseEntity<Person> actual = emblPersonManageRest.fetchPerson(personId);

        assertThat(actual.getBody()).isEqualTo(person);
        assertThat(actual.getStatusCodeValue()).isEqualTo(200);
    }

    /**
     * update person by personId
     */
    @Test
    public void updatePersonTest() {
        Long personId = someLong();
        Person person = mock(Person.class);

        emblPersonManageRest.updatePerson(personId, person);

        verify(personService, times(1)).updatePerson(personId, person);
    }

}
