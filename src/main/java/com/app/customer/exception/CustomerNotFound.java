package com.app.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFound extends RuntimeException {

    public CustomerNotFound(String resourceName, String feildName, Long feildValues) {
        super(String.format("%S not found given input data %s:%s", resourceName, feildName, feildValues));
    }

}
