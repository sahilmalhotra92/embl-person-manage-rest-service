package org.sahil.embl.person.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.sahil.embl.person.model.Person;
import org.sahil.embl.person.model.PersonDAO;
import org.sahil.embl.person.model.PersonDetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static shiver.me.timbers.data.random.RandomLongs.someLong;
import static shiver.me.timbers.data.random.RandomStrings.someAlphanumericString;
import static shiver.me.timbers.data.random.RandomStrings.someNumericString;

@RunWith(MockitoJUnitRunner.class)
public class PersonFactoryTest {

    @InjectMocks
    private PersonFactory personFactory;

    @Test
    public void translatePersonDao() {
        PersonDAO personDAO = mock(PersonDAO.class);
        String age = someNumericString(2);
        String firstName = someAlphanumericString();
        String lastName = someAlphanumericString();
        String favouriteColor = someAlphanumericString();
        Long id = someLong();

        when(personDAO.getAge()).thenReturn(age);
        when(personDAO.getFavouriteColour()).thenReturn(favouriteColor);
        when(personDAO.getFirstName()).thenReturn(firstName);
        when(personDAO.getLastName()).thenReturn(lastName);
        when(personDAO.getId()).thenReturn(id);

        PersonDetails actual = personFactory.translatePersonDao(personDAO);

        assertThat(actual).isNotNull();
        assertThat(actual.getPersonId()).isEqualTo(id);
        assertThat(actual.getAge()).isEqualTo(age);
        assertThat(actual.getFirstName()).isEqualTo(firstName);
        assertThat(actual.getLastName()).isEqualTo(lastName);
        assertThat(actual.getFavouriteColour()).isEqualTo(favouriteColor);
    }

    @Test
    public void translatePerson() {
        Person person = mock(Person.class);
        String age = someNumericString(2);
        String firstName = someAlphanumericString();
        String lastName = someAlphanumericString();
        String favouriteColor = someAlphanumericString();

        when(person.getAge()).thenReturn(age);
        when(person.getFavouriteColour()).thenReturn(favouriteColor);
        when(person.getFirstName()).thenReturn(firstName);
        when(person.getLastName()).thenReturn(lastName);

        PersonDAO actual = personFactory.translatePerson(person);

        assertThat(actual).isNotNull();
        assertThat(actual.getAge()).isEqualTo(age);
        assertThat(actual.getFirstName()).isEqualTo(firstName);
        assertThat(actual.getLastName()).isEqualTo(lastName);
        assertThat(actual.getFavouriteColour()).isEqualTo(favouriteColor);
    }
}