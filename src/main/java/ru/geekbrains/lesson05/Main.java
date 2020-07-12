package ru.geekbrains.lesson05;

import java.util.Arrays;

public class Main {

    private static final int SIZE = 10_000_000;
    private static final int HALF_SIZE = SIZE / 2;

    public static void main(String[] args) {
        sequentialProcessingOfArray();
        parallelProcessingOfArray();
        parallelProcessingOfArray_2();
    }

    public static void sequentialProcessingOfArray() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Method \"sequentialProcessingOfArray\" " + (finishTime - startTime));
//        System.out.println(Arrays.toString(array));
    }

    public static void parallelProcessingOfArray() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                float[] tempArray = new float[HALF_SIZE];
                System.arraycopy(array, 0, tempArray, 0, HALF_SIZE);
                for (int i = 0; i < tempArray.length; i++) {
                    tempArray[i] = (float) (tempArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(tempArray, 0, array, 0, HALF_SIZE);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                float[] tempArray = new float[HALF_SIZE];
                System.arraycopy(array, HALF_SIZE, tempArray, 0, HALF_SIZE);
                int tempI = 0;
                for (int i = 0; i < tempArray.length; i++) {
                    tempI = i + HALF_SIZE;
                    // Во втором потоке добавил деление на tempI что бы результирующие массивы в первом и втором методе были идентичны,
                    // на моей компе время выполнения сразу увеличиваеться с 1636 до 3898 мил/сек
                    tempArray[i] = (float) (tempArray[i] * Math.sin(0.2f + tempI / 5) * Math.cos(0.2f + tempI / 5) * Math.cos(0.4f + tempI / 2));
//                    tempArray[i] = (float)(tempArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(tempArray, 0, array, HALF_SIZE, HALF_SIZE);
            }
        });

        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finishTime = System.currentTimeMillis();

        System.out.println("Method \"parallelProcessingOfArray\" " + (finishTime - startTime));
//        System.out.println(Arrays.toString(array));
    }

    // Без использование System.arraycopy, каждый поток работает со своим диапазоном индексов.
    // Разница в скорости при размере 10_000_000 у меня parallelProcessingOfArray 3909, parallelProcessingOfArray_2 3887
    public static void parallelProcessingOfArray_2() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               calc(array, 0, HALF_SIZE);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calc(array, HALF_SIZE, SIZE);
            }
        });

        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finishTime = System.currentTimeMillis();

        System.out.println("Method \"parallelProcessingOfArray_2\" " + (finishTime - startTime));
//        System.out.println(Arrays.toString(array));
    }

    private static void calc(float[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
