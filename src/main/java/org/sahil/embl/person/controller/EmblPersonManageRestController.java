package org.sahil.embl.person.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sahil.embl.person.exception.ErrorResponse;
import org.sahil.embl.person.model.Person;
import org.sahil.embl.person.model.PersonDetails;
import org.sahil.embl.person.model.Persons;
import org.sahil.embl.person.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class EmblPersonManageRestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "create person", nickname = "createPerson", notes = "stores person in the database", response = Person.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "PersonDetails", response = Person.class),
            @ApiResponse(code = 400, message = "Bad request exception", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "interal server exception", response = ErrorResponse.class)})
    @PostMapping(value = "/api/v1/persons", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<PersonDetails> createPerson(@ApiParam(value = "Person") @Valid @RequestBody Person person) {
        logger.info("Create user with name {} {}", person.getFirstName(), person.getLastName());
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }


    @ApiOperation(value = "delete person by personId", nickname = "deletePerson", notes = "delete the person by personId from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "person deleted"),
            @ApiResponse(code = 400, message = "Bad request exception", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "not found exception", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "interal server exception", response = ErrorResponse.class)})
    @DeleteMapping(value = "/api/v1/persons/{personId}", produces = {"application/json"})
    public void deletePerson(@ApiParam(value = "", required = true) @PathVariable("personId") Long personId) {
        logger.info("Delete Person with personId {}", personId);
        personService.deletePerson(personId);
    }


    @ApiOperation(value = "fetch all the persons", nickname = "fetchAllPersons", notes = "fetch all the persons from the database", response = Persons.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person", response = Persons.class),
            @ApiResponse(code = 400, message = "Bad request exception", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "interal server exception", response = ErrorResponse.class)})
    @GetMapping(value = "/api/v1/persons", produces = {"application/json"})
    public ResponseEntity<Persons> fetchAllPersons() {
        logger.info("Fetching All Persons");
        return new ResponseEntity<>(personService.fetchAllPersons(), HttpStatus.OK);
    }


    @ApiOperation(value = "fetch person by personId", nickname = "fetchPerson", notes = "fetch the person by personId from the database", response = Person.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person", response = Person.class),
            @ApiResponse(code = 400, message = "Bad request exception", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "not found exception", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "interal server exception", response = ErrorResponse.class)})
    @GetMapping(value = "/api/v1/persons/{personId}", produces = {"application/json"})
    public ResponseEntity<Person> fetchPerson(@ApiParam(value = "", required = true) @PathVariable("personId") Long personId) {
        logger.info("Fetch Person with personId {}", personId);
        return new ResponseEntity<>(personService.fetchPerson(personId), HttpStatus.OK);
    }


    @ApiOperation(value = "update person by personId", nickname = "updatePerson", notes = "update the person by personId from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "person updated"),
            @ApiResponse(code = 400, message = "Bad request exception", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "not found exception", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "interal server exception", response = ErrorResponse.class)})
    @PutMapping(value = "/api/v1/persons/{personId}", produces = {"application/json"}, consumes = {"application/json"})
    public void updatePerson(@ApiParam(value = "", required = true) @PathVariable("personId") Long personId, @ApiParam(value = "Person") @Valid @RequestBody Person person) {
        logger.info("Update Person with personId {}", personId);
        personService.updatePerson(personId, person);
    }
}

