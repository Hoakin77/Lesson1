package ru.geekbrains.java2.homeworks.hw3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> book = new HashMap<>();

    public void add(String name, String number){
        book.getOrDefault(name, new HashSet<>()).add(number);
    }

}
