package org.sahil.embl.person.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sahil.embl.person.exception.NotFoundException;
import org.sahil.embl.person.model.Person;
import org.sahil.embl.person.model.PersonDetails;
import org.sahil.embl.person.model.Persons;
import org.sahil.embl.person.repository.PersonRepository;
import org.sahil.embl.person.service.PersonService;
import org.sahil.embl.person.spring.ComponentTestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

/**
 * API Component Tests
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ComponentTestContext.class)
public class EmblPersonManageRestControllerComponentTest {

    @Autowired
    private EmblPersonManageRestController emblPersonManageRest;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    /**
     * create person
     */
    @Test
    public void createPersonTest() {
        Person person = mock(Person.class);

        ResponseEntity<PersonDetails> actual = emblPersonManageRest.createPerson(person);

        assertThat(actual.getBody()).isNotNull();
        assertThat(actual.getStatusCodeValue()).isEqualTo(201);
    }

    /**
     * delete person by personId
     */
    @Test(expected = NotFoundException.class)
    public void deletePersonTest() {
        Long personId = someLong();

        emblPersonManageRest.deletePerson(personId);

        verify(personRepository, times(0)).deleteById(personId);
    }

    /**
     * fetch all the persons
     */
    @Test
    public void fetchAllPersonsTest() {

        ResponseEntity<Persons> actual = emblPersonManageRest.fetchAllPersons();

        assertThat(actual.getStatusCodeValue()).isEqualTo(200);
        assertThat(actual.getBody().getPerson().size()).isEqualTo(1);
    }

    /**
     * fetch person by personId
     */
    @Test(expected = NotFoundException.class)
    public void fetchPersonTest() {
        Long personId = someLong();

        ResponseEntity<Person> actual = emblPersonManageRest.fetchPerson(personId);

        assertThat(actual.getStatusCodeValue()).isEqualTo(200);
    }

    /**
     * update person by personId
     */
    @Test(expected = NotFoundException.class)
    public void updatePersonTest() {
        Long personId = someLong();
        Person person = mock(Person.class);

        emblPersonManageRest.updatePerson(personId, person);
    }

}
