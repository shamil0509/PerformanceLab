package ru.bakirov.filereading;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<Integer> read(String fileName) throws IOException;
}
