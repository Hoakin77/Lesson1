package ru.geekbrains.java2.homeworks.hw2;

public class Main {
    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"2", "2", "2", "3"}, {"1", "2", "2", "2"}, {"2", "2", "2", "2"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
        }

    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : arr) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
            for (String string : strings) {
                try {
                    count = count + Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }

        }
        return count;
    }

}
