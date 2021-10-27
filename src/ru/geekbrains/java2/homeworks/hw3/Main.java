package ru.geekbrains.java2.homeworks.hw3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
      arrayWords();
    }

    static void arrayWords(){
        List<String> strings = new ArrayList<>();
        strings.add("Яблоко");
        strings.add("Манго");
        strings.add("Маракуя");
        strings.add("Персик");
        strings.add("Вишня");
        strings.add("Черешня");
        strings.add("Малина");
        strings.add("Черника");
        strings.add("Яблоко");
        strings.add("Вишня");

        Set <String> unique = new HashSet<>(strings);
        System.out.println(unique);

        for (int i = 0; i < unique.size(); i++) {
            System.out.println(i);
        }
    }
}
