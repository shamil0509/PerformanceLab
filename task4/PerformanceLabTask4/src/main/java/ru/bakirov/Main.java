package ru.bakirov;

import ru.bakirov.filereading.FileReader;
import ru.bakirov.filereading.FileReaderImpl;
import ru.bakirov.validation.Validation;
import ru.bakirov.validation.ValidationImpl;

public class Main {

    public static void main(String[] args) {

        Validation validation = new ValidationImpl();
        FileReader fileReader = new FileReaderImpl(validation);
        Task4 task4 = new Task4(fileReader);

        System.out.println(task4.task4());
    }
}
