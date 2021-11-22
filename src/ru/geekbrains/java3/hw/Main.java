package ru.geekbrains.java3.hw;

import org.junit.Test;

import java.util.*;

/**
 * 1. Написать метод, который меняет два элемента массива местами.
 * (массив может быть любого ссылочного типа);
 * <p>
 * 2. Написать метод, который преобразует массив в ArrayList;
 * <p>
 * 3. Большая задача:
 * Есть классы Fruit -> Apple, Orange; (больше фруктов не надо)
 * Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можете использовать ArrayList;
 * Сделать метод getWeight() который высчитывает вес коробки, зная кол-во фруктов и вес
 * одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку
 * с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в
 * противной случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
 * (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
 * соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
 * которые были в этой коробке;
 * Ну и не забываем про метод добавления фрукта в коробку;
 */
public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Box<Apple> appleBox1 = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());


        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox1.getWeight());

        System.out.println(appleBox.compare(appleBox1));
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(orangeBox1.compare(orangeBox));

        appleBox.pour(appleBox1);
        orangeBox.pour(orangeBox1);

    }


    /**
     * 1. Написать метод, который меняет два элемента массива местами.
     * (массив может быть любого ссылочного типа);
     */

    static void swapObj(Object[] array, int secondIndex) {
        Object firstVal = array[2];
        array[2] = array[secondIndex];
        array[secondIndex] = firstVal;
    }
    @Test
    public void shiftInteger() {
        Integer[] expected = {56, 31, 8};
        Integer[] actual = {8, 31, 56};

        Main.swapObj(actual, 0);
        Main.swapObj(expected, 0);
    }
    @Test
    public void shiftString() {
        String[] expected = {"one", "two", "three"};
        String[] actual = {"one", "three", "two"};

        Main.swapObj(actual, 1);
        Main.swapObj(expected, 1);
    }


    /**
     * 2. Написать метод, который преобразует массив в ArrayList;
     */

    static <T> ArrayList<T> convertToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    @Test
    public void convertCharacterToList() throws Exception {
        Character[] charArray = {'a', 'b', (byte) 33, (byte) 0x32};
        List<Character> list = Main.convertToList(charArray);
    }
    @Test
    public void convertIntegerToList() throws Exception {
        Integer[] intArray = {100, 30, 15};
        List<Integer> list = Main.convertToList(intArray);
    }


}
