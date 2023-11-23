package com.diplomado.ApiRestSpringBoot.exception;

import com.diplomado.ApiRestSpringBoot.domain.payload.ApiResponse;
import com.diplomado.ApiRestSpringBoot.domain.payload.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception,
                                                                   WebRequest webRequest){
       ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Response> handlerUserAlreadyExistsException(UserAlreadyExistsException exception,
                                                                      WebRequest webRequest){
        Response response = new Response(exception.getMessage(),new Date(), webRequest.getDescription(false),
                HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(RecurseAlreadyExistsException.class)
    public ResponseEntity<Response> handlerUserAlreadyExistsException(RecurseAlreadyExistsException exception,
                                                                      WebRequest webRequest){
        Response response = new Response(exception.getMessage(),new Date(), webRequest.getDescription(false),
                HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ServerResponseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handlerUserAlreadyExistsException(ServerResponseException exception){

        String massege = "Error interno"+ exception.getMessage();
        return new ResponseEntity<>(massege,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }




}
