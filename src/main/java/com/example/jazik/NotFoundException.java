package com.example.jazik;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("House not found!");
    }
}
