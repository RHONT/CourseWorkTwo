package ru.rhontcompany.aqapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class MyHandler {

    @ExceptionHandler({StopedMathRepository.class})
    public ResponseEntity<String> stopMathMethodRepository(Exception e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler({NoSuchElementException.class,IllegalArgumentException.class})
    public ResponseEntity<String> userFail(Exception e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
