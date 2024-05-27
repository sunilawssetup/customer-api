package com.app.customer.exception;

import com.app.customer.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String,String> validationError=new HashMap<>();
        List<ObjectError> validErrors=ex.getBindingResult().getAllErrors();
        validErrors.forEach(objectError ->{
            String fieldName=((FieldError)objectError).getField();
            String validMessage=objectError.getDefaultMessage();
            validationError.put(fieldName,validMessage);
        });
        return new ResponseEntity<>(validationError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerNotFound(RuntimeException runtimeException, WebRequest webRequest) {

        return new ResponseEntity<>(ErrorResponseDto.builder()
                .errorPath(webRequest.getDescription(false))
                .errorDescription(runtimeException.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .localDateTime(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistException(RuntimeException runtimeException, WebRequest webRequest) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .errorPath(webRequest.getDescription(false))
                .errorDescription(runtimeException.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .localDateTime(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
