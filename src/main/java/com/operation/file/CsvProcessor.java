package com.operation.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class CsvProcessor implements FileProcessor {
    @Override
    public void process(String filePath) {

        System.out.println("processing csv file");

        readFile.accept(filePath);
        writeFile.accept("/home/pradeeparya/Downloads/output");

    }

    private Function<String, List<String>> readerRead = (filePath) -> {

        List<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.lines().skip(1).forEach(line -> {
                lines.add(line);
            });
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    };

    private Function<String, List<String>> inputStreamRead = (filePath) -> {

        List<String> lines = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[1000];

            while (fileInputStream.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    };

    private Function<String, List<String>> filesRead = (filePath) -> {

        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(filePath);

            Files.lines(path).skip(1).forEach(line -> {
                lines.add(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    };

    private Consumer<List<String>> print = (lines) ->
            lines.stream().forEach(System.out::println);

    private Consumer<String> readFile = (filePath) -> {
        System.out.println("FileReader : ");
        List<String> lines = readerRead.apply(filePath);
        print.accept(lines);
        System.out.println("##################################################");
        System.out.println("FileInputStream : ");
        inputStreamRead.apply(filePath);
        System.out.println("##################################################");
        System.out.println("Files Read : ");
        lines = filesRead.apply(filePath);
        print.accept(lines);
    };

    private Consumer<String> writerWrite = (filePath) -> {

        try {

            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("hello,world,this,is,filewriter");
            bufferedWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    };

    private Consumer<String> outputStreamWrite = (filePath) -> {

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            fileOutputStream.write("hello,world,this,is,fileOutputStream".getBytes());
            fileOutputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    };

    private Consumer<String> filesWrite = (filePath) -> {

        try {

            Path path = Paths.get(filePath);
            Files.write(path, "hello,world,this,is,fileswrite".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    private Consumer<String> writeFile = (filePath) -> {
        writerWrite.accept(filePath + "1.csv");
        System.out.println("FileWriter done ");
        System.out.println("##################################################");
        outputStreamWrite.accept(filePath + "2.csv");
        System.out.println("FileOutputStream done ");
        System.out.println("##################################################");
        filesWrite.accept(filePath + "3.csv");
        System.out.println("Files Write done ");
    };
}
