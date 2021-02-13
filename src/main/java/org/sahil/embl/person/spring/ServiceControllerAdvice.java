package org.sahil.embl.person.spring;

import org.sahil.embl.person.exception.ErrorResponse;
import org.sahil.embl.person.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.util.StringUtils.collectionToCommaDelimitedString;

@ControllerAdvice(annotations = RestController.class)
public class ServiceControllerAdvice {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @ExceptionHandler({RuntimeException.class, IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception) {
        logger.error("", exception);
        return buildResponse(exception.getMessage(), exception.getLocalizedMessage(), exception.getClass().getName(), 500);
    }

    @ResponseBody
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(ErrorResponse exception) {
        return buildResponse(exception.getMessage(), exception.getError(), exception.getClass().getName(), 404);
    }

    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> handleInvalidJson(HttpMessageNotReadableException exception) {
        return buildResponse(exception.getMessage(), "Invalid Request", exception.getClass().getName(), 400);
    }

    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> fields = new ArrayList<>();
        List<String> messages = new ArrayList<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            fields.add(fieldError.getField());
            messages.add(fieldError.getDefaultMessage());
        }
        return buildResponse(collectionToCommaDelimitedString(messages), collectionToCommaDelimitedString(fields), exception.getClass().getName(), 400);
    }

    private ResponseEntity<ErrorResponse> buildResponse(String message, String error, String exception, int status) {
        ErrorResponse errorResponse = new ErrorResponse(message, error, exception, new Date().toString());
        logger.error("Error message {} , error {}, exception {}, code {} ", message, error, exception, status);
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(status));
    }
}
