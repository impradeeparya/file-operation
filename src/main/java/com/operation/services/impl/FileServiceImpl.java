package com.operation.services.impl;

import com.operation.services.FileService;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 10/1/17
 * Time: 10:09 PM
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

    @Override
    public void move(File sourceFile, File destinationFile) throws IOException {
        copy(sourceFile, destinationFile);
        sourceFile.delete();
    }

    @Override
    public void copy(File sourceFile, File destinationFile) throws IOException {
        InputStream inputStream = new FileInputStream(sourceFile);
        OutputStream outStream = new FileOutputStream(destinationFile);
        byte[] buffer = new byte[1024];

        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outStream.write(buffer, 0, length);
        }

        inputStream.close();
        outStream.close();
    }
}
