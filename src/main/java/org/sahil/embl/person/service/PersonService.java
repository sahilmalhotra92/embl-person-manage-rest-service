package org.sahil.embl.person.service;

import org.sahil.embl.person.exception.NotFoundException;
import org.sahil.embl.person.factory.PersonFactory;
import org.sahil.embl.person.model.Person;
import org.sahil.embl.person.model.PersonDAO;
import org.sahil.embl.person.model.PersonDetails;
import org.sahil.embl.person.model.Persons;
import org.sahil.embl.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    public static final String NOT_FOUND = "Person %s is not found";

    @Autowired
    private PersonFactory personFactory;

    @Autowired
    private PersonRepository personRepository;

    public PersonDetails createPerson(Person person) {
        PersonDAO personDAO = personFactory.translatePerson(person);
        PersonDAO savedPerson = personRepository.save(personDAO);
        return personFactory.translatePersonDao(savedPerson);
    }

    public void deletePerson(Long personId) {
        Optional<PersonDAO> optionalPersonDAO = personRepository.findById(personId);
        if (optionalPersonDAO.isPresent()) {
            personRepository.deleteById(personId);
        } else {
            throw new NotFoundException(String.format(NOT_FOUND, personId));
        }
    }

    public Persons fetchAllPersons() {
        List<PersonDAO> personDAOList = personRepository.findAll();
        if (!personDAOList.isEmpty()) {
            List<Person> personList = personDAOList.stream().map(personDAO -> personFactory.translatePersonDao(personDAO)).collect(Collectors.toList());
            return new Persons(personList);
        } else {
            return new Persons();
        }
    }

    public Person fetchPerson(Long personId) {
        Optional<PersonDAO> optionalPersonDAO = personRepository.findById(personId);
        if (optionalPersonDAO.isPresent()) {
            return personFactory.translatePersonDao(optionalPersonDAO.get());
        }
        throw new NotFoundException(String.format(NOT_FOUND, personId));
    }

    public void updatePerson(Long personId, Person person) {
        Optional<PersonDAO> optionalPersonDAO = personRepository.findById(personId);
        if (optionalPersonDAO.isPresent()) {
            PersonDAO dbPerson = optionalPersonDAO.get();
            dbPerson.setAge(person.getAge());
            dbPerson.setFirstName(person.getFirstName());
            dbPerson.setLastName(person.getLastName());
            dbPerson.setFavouriteColour(person.getFavouriteColour());
            personRepository.save(dbPerson);
        } else {
            throw new NotFoundException(String.format(NOT_FOUND, personId));
        }
    }
}
