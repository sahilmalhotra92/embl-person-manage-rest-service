package org.sahil.embl.person.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed"})
public class ErrorResponse extends RuntimeException {
    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private String error;

    @JsonProperty("exception")
    private String exception;

    @JsonProperty("time")
    private String time;

    public ErrorResponse(String message, String error, String exception, String time) {
        this.message = message;
        this.error = error;
        this.exception = exception;
        this.time = time;
    }

    @Override
    public String getMessage() {
        return message;
    }


    public String getError() {
        return error;
    }

}