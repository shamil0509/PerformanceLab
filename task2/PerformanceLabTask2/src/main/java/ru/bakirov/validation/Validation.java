package ru.bakirov.validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface Validation {

    void validateFileExists(Path path, String exceptionMessage) throws IOException;

    void validateFileNotEmpty(File file, String exceptionMessage) throws IOException;

    void validateFileNotDirectory(Path path, String exceptionMessage) throws IOException;
}
