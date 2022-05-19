package ru.bakirov.validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ValidationImpl implements Validation {

    public void validateFileExists(Path path, String exceptionMessage) throws IOException {
        if (Files.notExists(path)) {
            throw new IOException(exceptionMessage);
        }
    }

    public void validateFileNotEmpty(File file, String exceptionMessage) throws IOException {
        if (file.length() == 0) {
            throw new IOException(exceptionMessage);
        }
    }

    public void validateFileNotDirectory(Path path, String exceptionMessage) throws IOException {
        if (Files.isDirectory(path)) {
            throw new IOException(exceptionMessage);
        }
    }
}
