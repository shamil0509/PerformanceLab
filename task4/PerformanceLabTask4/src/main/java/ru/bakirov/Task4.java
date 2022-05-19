package ru.bakirov;

import ru.bakirov.filereading.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {

    private FileReader fileReader;

    public Task4(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public int task4() {

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        List<Integer> nums = new ArrayList<>();
        try {
            nums = fileReader.read(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int minValue = nums.get(0);
        for (int num : nums) {
            if (minValue > num) {
                minValue = num;
            }
        }

        int maxValue = nums.get(0);
        for (int num : nums) {
            if (maxValue < num) {
                maxValue = num;
            }
        }

        int averageValue = (minValue + maxValue) / 2;

        int moves = 0;
        for (int num : nums) {
            moves = moves + Math.abs(num - averageValue);
        }

        return moves;
    }
}
