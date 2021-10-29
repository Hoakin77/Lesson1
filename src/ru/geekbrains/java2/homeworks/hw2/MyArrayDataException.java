package ru.geekbrains.java2.homeworks.hw2;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
