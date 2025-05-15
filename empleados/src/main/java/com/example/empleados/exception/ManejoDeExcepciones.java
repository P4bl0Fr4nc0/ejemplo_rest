
package com.example.empleados.exception;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//Manejador de excepciones

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ManejoDeExcepciones    {


    //Excepcion cuando el empleado no es encontrado
    @ExceptionHandler(value = EmpleadoNoEncontradoException.class)
    public ResponseEntity<com.example.empleados.exception.ErrorResponse> handleEmpleadoNoEncontradoException(EmpleadoNoEncontradoException e){
       ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    //Excepcion cuando ocurre un error interno del servidor
    @ExceptionHandler(value=Exception.class)
    public  ResponseEntity<ErrorResponse> handleException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
