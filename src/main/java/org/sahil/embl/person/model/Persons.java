package org.sahil.embl.person.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persons {


    @JsonProperty("person")
    private List<Person> person = new ArrayList<>();

    public Persons(List<Person> person) {
        this.person = person;
    }

    public Persons() {
    }

    /**
     * @return person
     **/
    public List<Person> getPerson() {
        return person;
    }


}



