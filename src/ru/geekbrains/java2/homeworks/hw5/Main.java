package ru.geekbrains.java2.homeworks.hw5;

import java.util.Arrays;

//
// *          1. Необходимо написать два метода, которые делают следующее:
//         *          <p>
// *          Создают одномерный длинный массив, например:
//         *          static final int size = 10000000;
//        *          static final int h = size / 2;
//        *          float[] arr = new float[size];
//        *          Заполняют этот массив единицами;
//        *          Засекают время выполнения: long a = System.currentTimeMillis();
//        *          Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//        *          arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        *          Проверяется время окончания метода System.currentTimeMillis();
//        *          В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//        *          Чем отличается первый метод от второго:
//        *          <p>
// *          Первый бежит по массиву и высчитывает значения.
//         *          <p>
// *          Второй разбивает массив на два массива, в двух потоках высчитывает новые значения, и потом склеивает эти массивы обратно в один.
//         *          <p>
// *          Пример деления одного массива на два:
//         *          System.arraycopy(arr, 0, a1, 0, h);
//         *          System.arraycopy(arr, h, a2, 0, h);
//         *          Пример обратной склейки:
//         *          System.arraycopy(a1, 0, arr, 0, h);
//         *          System.arraycopy(a2, 0, arr, q, h);
//         *          По замерам времени:
//         *          Для первого метода надо считать время только на цикл расчета:
//         *          for (int i = 0; i < size; i++) {
//        *          arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        *          }
//        *          Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
public class Main {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;
    private float []arr = new float[SIZE];

    private void doCalc(){
        long start = System.currentTimeMillis();
        Arrays.fill(arr, 1);

        float[] a1 = new float[HALF_SIZE];
        float[] a2 = new float[HALF_SIZE];

        System.arraycopy(arr, 0,a1,0,HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE,a2,0,HALF_SIZE);

        Thread t0 = new Thread(()-> doCalc(a1));
        Thread t1 = new Thread(()-> doCalc(a2));

        t0.start();
        t1.start();

        try {
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1,0,arr,0, HALF_SIZE);
        System.arraycopy(a2,0,arr, HALF_SIZE, HALF_SIZE);

        long end = System.currentTimeMillis() - start;
        System.out.println("Operation took: " + end);
    }

    private void doCalc(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
    }

    public static void main(String[] args) {
        new Main().doCalc();
    }
}
