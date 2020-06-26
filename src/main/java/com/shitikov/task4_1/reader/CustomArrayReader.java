package com.shitikov.task4_1.reader;

import com.shitikov.task4_1.exception.ProjectException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomArrayReader {

    public List<String> readFile(String fileName) {
        List<String> dataList = new ArrayList<>();
        Path path = Paths.get(fileName);

        if (Files.exists(path) && !Files.isDirectory(path) && Files.isReadable(path)) {
            try (Stream<String> dataStream = Files.lines(path)) {
                dataList = dataStream.collect(Collectors.toList());
            } catch (IOException | UncheckedIOException e) {
                throw new RuntimeException("Program error.", e);
            }
        }
        return dataList;
    }

    public String readConsole() throws ProjectException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String result;
            result = reader.readLine();

            return result;
        } catch (IOException e) {
            throw new ProjectException("Console error");
        }
    }
}
