package com.operation.services.impl;

import com.operation.services.FileService;
import com.operation.services.FileUploader;
import com.operation.services.FileWatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 9/1/17
 * Time: 7:33 PM
 */

@Service("excelFileWatcher")
public class ExcelFileWatcher implements FileWatcher {

    @Autowired
    private Environment environment;

    @Autowired
    @Qualifier("excelFileUploader")
    private FileUploader excelFileUpload;

    @Autowired
    private FileService fileService;

    @PostConstruct
    public void postConstruct() {
//        watch(environment.getProperty("file.watcher.directory.path"));
    }

    @Override
    public void watch(String path) {
        Path dirToWatch = Paths.get(path);
        try {
            WatchService watchService = dirToWatch.getFileSystem().newWatchService();
            dirToWatch.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            while (true) {
                WatchKey watchKey = watchService.poll(10, TimeUnit.MINUTES);
                if (watchKey != null) {
                    watchKey.pollEvents().stream().forEach(event -> {
                        File file = new File(environment.getProperty("file.watcher.directory.path") + "/" + event.context().toString());
                        try {
                            fileService.move(file, new File(environment.getProperty("file.output.directory.path") + "/" + event.context().toString()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    watchKey.reset();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void preDestroy() {
    }

}
