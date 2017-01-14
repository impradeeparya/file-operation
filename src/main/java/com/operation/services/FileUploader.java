package com.operation.services;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 14/12/16
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FileUploader {

    void parser(InputStream content) throws IOException, InvalidFormatException;

}
