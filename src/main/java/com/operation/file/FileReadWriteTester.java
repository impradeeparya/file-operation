package com.operation.file;

public class FileReadWriteTester {

    public static void main(String[] args) {

        String filePath = "/home/pradeeparya/Downloads/SacramentocrimeJanuary2006.csv";


        FileProcessor fileProcessor = ProcessorFactory.processor(FileType.CSV);
        fileProcessor.process(filePath);


    }
}
