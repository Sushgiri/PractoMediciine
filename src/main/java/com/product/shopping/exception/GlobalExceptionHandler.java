package com.product.shopping.exception;

import com.product.shopping.dto.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourcenotfound(
            ResourceNotFoundException exception,
            WebRequest webRequest
){
    ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(true));
    return new ResponseEntity<>(errorDetails,INTERNAL_SERVER_ERROR);
}

@ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<ErrorDetails> outofstock(
            OutOfStockException outOfStockException,
            WebRequest webRequest
){

    ErrorDetails errorDetails = new ErrorDetails(new Date(),outOfStockException.getMessage(), webRequest.getDescription(true));
  return new ResponseEntity<>(errorDetails,INTERNAL_SERVER_ERROR);
}

}
