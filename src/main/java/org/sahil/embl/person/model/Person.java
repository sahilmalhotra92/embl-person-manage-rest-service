package org.sahil.embl.person.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @NotNull(message = "firstName cannot be null")
    @NotBlank(message = "firstName cannot be blank")
    @Size(max = 256, min = 2)
    @JsonProperty("firstName")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @NotBlank(message = "lastName cannot be blank")
    @Size(max = 256, min = 2)
    @JsonProperty("lastName")
    private String lastName;

    @NotNull(message = "age cannot be null")
    @NotBlank(message = "age cannot be blank")
    @Pattern(regexp = "^(\\d{0,2}(\\.\\d{1,2}\u200B)?|100(\\.00?)?)$", message = "must be number and less than 100")
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



