package com.bidzana.library.domain.exception;

// On hérite de RuntimeException pour ne pas polluer les signatures de méthodes
public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}
