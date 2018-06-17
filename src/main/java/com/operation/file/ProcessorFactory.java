package com.operation.file;

public class ProcessorFactory {

    public static FileProcessor processor(FileType fileType) {

        FileProcessor fileProcessor;

        switch (fileType) {
            case CSV:
                fileProcessor = new CsvProcessor();
                break;
            default:
                fileProcessor = null;
                break;
        }


        return fileProcessor;

    }
}
