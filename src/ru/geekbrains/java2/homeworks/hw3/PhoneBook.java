package ru.geekbrains.java2.homeworks.hw3;

import java.util.Set;

public interface PhoneBook {
    void add(String surname, String phoneNumber);

    Set<String> get(String surname);

    Set<String> getAllSurnames();
}
