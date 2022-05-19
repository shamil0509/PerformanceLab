package ru.bakirov;

import java.util.Scanner;

public class Task1 {

    public String task1() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        int firstIndex = 0;
        StringBuilder stringBuilder = new StringBuilder();

        do {

            stringBuilder.append(array[firstIndex]);
            firstIndex = firstIndex + m - 1;

            if (firstIndex > array.length - 1) {
                firstIndex = firstIndex - array.length;
            }

        } while (firstIndex != 0);

        return stringBuilder.toString();
    }
}
