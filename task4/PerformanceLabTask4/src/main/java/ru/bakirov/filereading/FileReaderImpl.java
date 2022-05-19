package ru.bakirov.filereading;

import ru.bakirov.validation.Validation;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {

    private Validation validation;

    public FileReaderImpl(Validation validation) {
        this.validation = validation;
    }

    private static final String STREAM_WAS_NOT_CLOSED_EXCEPTION_MESSAGE = "Stream was not closed.";
    private static final String FILE_IS_EMPTY_EXCEPTION_MESSAGE = "File is empty.";
    private static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "File is not found.";
    private static final String FILE_IS_DIRECTORY_EXCEPTION_MESSAGE = "Input path represents directory instead of file";
    private static final String EMPTY_STRING = "";
    public static final String EXCEPTION_IN_METHOD_READ = "Exception in method 'read'.";

    public List<Integer> read(String fileName) {

        List<String> linesFromFile = new ArrayList<>();
        Path path = Paths.get(EMPTY_STRING);

        try {
            URL resource = getClass().getClassLoader().getResource(fileName);
            File file = Paths.get(resource.toURI()).toFile();
            String fullPath = file.getAbsolutePath();

            path = Paths.get(fullPath);
            validation.validateFileNotDirectory(path, FILE_IS_DIRECTORY_EXCEPTION_MESSAGE);
            validation.validateFileExists(path, FILE_NOT_FOUND_EXCEPTION_MESSAGE);

            validation.validateFileNotEmpty(file, FILE_IS_EMPTY_EXCEPTION_MESSAGE);
        } catch (IOException | URISyntaxException | NullPointerException e1) {
            e1.printStackTrace();
            System.out.println(EXCEPTION_IN_METHOD_READ);
        }

        try (Stream<String> streamWithFile = Files.lines(path)) {
            linesFromFile = streamWithFile.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(STREAM_WAS_NOT_CLOSED_EXCEPTION_MESSAGE);
        }

        List<Integer> output = new ArrayList<>();
        for (String line :
                linesFromFile) {
            output.add(Integer.valueOf(line));
        }

        return output;
    }
}
