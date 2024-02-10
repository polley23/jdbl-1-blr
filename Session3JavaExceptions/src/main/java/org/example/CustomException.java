package org.example;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
