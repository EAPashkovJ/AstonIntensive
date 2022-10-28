package Pattern.FactoryMethod;

import java.io.*;
import java.util.stream.Collectors;

public interface Instruction {
    String getInstruction(String path);


    default String readInstruction(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

