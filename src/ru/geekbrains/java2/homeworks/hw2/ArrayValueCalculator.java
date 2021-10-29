package ru.geekbrains.java2.homeworks.hw2;

public class ArrayValueCalculator {
    public int calculator(String[][] array) {
        checkSize(array.length);

        for (int i = 0; i < array.length; i++) {
            checkSize(array[i].length);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Value is not is int - parsable: [%s] [%s]" + i, j),
                            e);

                }
            }
        }
        return sum;
    }

    private void checkSize(int length) {
        if (length != 4) {
            throw new MyArraySizeException("Array should be 4-length");
        }
    }
}
