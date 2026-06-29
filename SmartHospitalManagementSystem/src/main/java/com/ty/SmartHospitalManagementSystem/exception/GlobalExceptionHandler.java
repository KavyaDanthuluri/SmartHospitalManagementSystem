package com.ty.SmartHospitalManagementSystem.exception;

import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleResourceNotFoundException(ResourceNotFoundException exception){
        ResponseStructure<String> rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Not Found");
        rs.setData(exception.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ResponseStructure<String >> handleResourceAlreadyExistsException(ResourceAlreadyExistsException exception){
        ResponseStructure<String> rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CONFLICT.value());
        rs.setMessage("Duplicate Data");
        rs.setData(exception.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseStructure<Map<String,String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        for(FieldError error : exception.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        ResponseStructure<Map<String,String>> rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
        rs.setMessage("Invalid data");
        rs.setData(errors);
        return new ResponseEntity<ResponseStructure<Map<String,String>>>(rs,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseStructure<String>> handleInvalidDataException(HttpMessageNotReadableException exception){
        ResponseStructure<String> rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
        rs.setMessage("Violated the Business rules");
        rs.setData(exception.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
    }
}
