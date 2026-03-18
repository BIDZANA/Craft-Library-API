package com.bidzana.library.infrastructure.adapters.input.advice;

import com.bidzana.library.domain.exception.OutOfStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<Object> handleOutOfStock(OutOfStockException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "timestamp", LocalDateTime.now(),
                "message", ex.getMessage(),
                "status", HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleNotFound(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "message", ex.getMessage()
        ));
    }
}