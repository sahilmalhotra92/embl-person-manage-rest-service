package org.sahil.embl.person.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.sahil.embl.person.exception.ErrorResponse;
import org.sahil.embl.person.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceControllerAdviceTest {
    @InjectMocks
    private ServiceControllerAdvice advice;

    @Test
    public void handleRuntimeException() {
        RuntimeException exception = mock(RuntimeException.class);

        ResponseEntity<ErrorResponse> actual = advice.handleRuntimeException(exception);

        assertThat(actual.getStatusCode().value()).isEqualTo(500);
        assertNotNull(actual.getBody());
    }


    @Test
    public void handleNotFoundException() {
        NotFoundException exception = mock(NotFoundException.class);

        ResponseEntity<ErrorResponse> actual = advice.handleNotFoundException(exception);

        assertThat(actual.getStatusCode().value()).isEqualTo(404);
        assertNotNull(actual.getBody());
    }


    @Test
    public void handleInvalidJson() {
        HttpMessageNotReadableException exception = mock(HttpMessageNotReadableException.class);

        ResponseEntity<ErrorResponse> actual = advice.handleInvalidJson(exception);

        assertThat(actual.getStatusCode().value()).isEqualTo(400);
        assertNotNull(actual.getBody());
    }

    @Test
    public void handleMethodArgumentNotValidException() {
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = mock(FieldError.class);
        List<FieldError> fieldErrorList = new ArrayList<>();
        fieldErrorList.add(fieldError);

        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrorList);

        ResponseEntity<ErrorResponse> actual = advice.handleMethodArgumentNotValidException(exception);

        assertThat(actual.getStatusCode().value()).isEqualTo(400);
        assertNotNull(actual.getBody());
    }
}