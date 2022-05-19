package ru.bakirov;

import ru.bakirov.filereading.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    private FileReader fileReader;

    public Task2(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void task2() {

        Scanner scanner = new Scanner(System.in);
        String circleFileName = scanner.nextLine();
        String pointsFileName = scanner.nextLine();

        List<String> circleData = new ArrayList<>();
        try {
            circleData = fileReader.read(circleFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> points = new ArrayList<>();
        try {
            points = fileReader.read(pointsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] circleCenter = circleData.get(0).split(" ");
        float circleCenterX = Float.parseFloat(circleCenter[0]);
        float circleCenterY = Float.parseFloat(circleCenter[1]);
        float radius = Float.parseFloat(circleData.get(1));

        for (String point : points) {
            String[] coordinates = point.split(" ");
            float pointX = Float.parseFloat(coordinates[0]);
            float pointY = Float.parseFloat(coordinates[1]);

            float lengthBetweenPointAndCenter =
                    (float) Math.sqrt(Math.pow(Float.sum(circleCenterX, - pointX), 2)
                            + Math.pow(Float.sum(circleCenterY, - pointY), 2));

            if (Float.compare(lengthBetweenPointAndCenter, radius) == 0) {
                System.out.println(0);
            }
            if (Float.compare(lengthBetweenPointAndCenter, radius) < 0) {
                System.out.println(1);
            }
            if (Float.compare(lengthBetweenPointAndCenter, radius) > 0) {
                System.out.println(2);
            }
        }
    }
}
