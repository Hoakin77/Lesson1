package ru.geekbrains.java2.homeworks.hw3;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        PhoneBook phoneBook = new MyPhoneBook();
        phoneBook.add("Krylov", "777-77-77");
        phoneBook.add("Ivanov", "555-55-55");
        phoneBook.add("Petrov", "666-66-66");
        phoneBook.add("Ivanov", "888-88-88");
        phoneBook.add("Ivanov", "777-77-77");

        Set<String> allSurnames = phoneBook.getAllSurnames();
        for (String surname : allSurnames) {
            Set<String> phones = phoneBook.get(surname);
            System.out.printf("%s: %s%n", surname, phones);
        }
    }
}
