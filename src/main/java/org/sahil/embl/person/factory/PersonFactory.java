package org.sahil.embl.person.factory;

import org.sahil.embl.person.model.Person;
import org.sahil.embl.person.model.PersonDAO;
import org.sahil.embl.person.model.PersonDetails;
import org.springframework.stereotype.Component;

@Component
public class PersonFactory {
    public PersonDetails translatePersonDao(PersonDAO personDAO) {
        PersonDetails person = new PersonDetails();
        person.setAge(personDAO.getAge());
        person.setFavouriteColour(personDAO.getFavouriteColour());
        person.setFirstName(personDAO.getFirstName());
        person.setLastName(personDAO.getLastName());
        person.setPersonId(personDAO.getId());
        return person;
    }

    public PersonDAO translatePerson(Person person) {
        PersonDAO personDAO = new PersonDAO();
        personDAO.setAge(person.getAge());
        personDAO.setFavouriteColour(person.getFavouriteColour());
        personDAO.setFirstName(person.getFirstName());
        personDAO.setLastName(person.getLastName());
        return personDAO;
    }
}
