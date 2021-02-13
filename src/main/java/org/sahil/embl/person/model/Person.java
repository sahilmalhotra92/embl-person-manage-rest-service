package org.sahil.embl.person.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @NotNull(message = "firstName cannot be null")
    @NotBlank(message = "firstName cannot be blank")
    @JsonProperty("firstName")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @NotBlank(message = "lastName cannot be blank")
    @JsonProperty("lastName")
    private String lastName;

    @NotNull(message = "age cannot be null")
    @NotBlank(message = "age cannot be blank")
    @Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "must be number")
    @JsonProperty("age")
    private String age;

    @NotNull(message = "favouriteColour cannot be null")
    @NotBlank(message = "favouriteColour cannot be blank")
    @JsonProperty("favouriteColour")
    private String favouriteColour;

    /**
     * @return firstName
     **/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return lastName
     **/
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return age
     **/
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return favouriteColour
     **/
    public String getFavouriteColour() {
        return favouriteColour;
    }

    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }
}



