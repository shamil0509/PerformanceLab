package ru.bakirov;

import ru.bakirov.filereading.FileReader;
import ru.bakirov.filereading.FileReaderImpl;
import ru.bakirov.validation.Validation;
import ru.bakirov.validation.ValidationImpl;

public class Main {

    public static void main(String[] args) {

        Validation validation = new ValidationImpl();
        FileReader fileReader = new FileReaderImpl(validation);
        Task2 task2 = new Task2(fileReader);

        task2.task2();
    }
}
