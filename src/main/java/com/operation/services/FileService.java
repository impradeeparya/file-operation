package com.operation.services;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 10/1/17
 * Time: 10:05 PM
 */
public interface FileService {

    void move(File sourceFile, File destinationFile) throws IOException;

    void copy(File sourceFile, File destinationFile) throws IOException;
}
