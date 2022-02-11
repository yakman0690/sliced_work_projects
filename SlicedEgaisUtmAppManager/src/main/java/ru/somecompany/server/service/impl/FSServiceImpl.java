/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.server.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;
import static org.springframework.util.StreamUtils.BUFFER_SIZE;
import ru.somecompany.server.service.FSService;

/**
 *
 * @author Alexandra
 */
public class FSServiceImpl implements FSService {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FSServiceImpl.class);
    private String folderName;

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    
    private String getFileContent(String filename) {
        String hash = null;
        try {
            File file = new File(filename);
            hash = FileUtils.readFileToString(file, "Utf-8");
        } catch (IOException ex) {
            logger.error("file "+filename+" doesn't exist");
        }
        return hash;
    }

    @Override
    public String getCurrentVersionHash() {
        return getFileContent("hash.txt");
    }
    
    @Override
    public String getDownloadedVersionHash() {
        return getFileContent("downloaded.txt");
    }
    
    private void setFileContent(String filename, String content){
        try {
            File file = new File(filename);
            file.createNewFile();
            logger.info("refreshing "+filename+" to " + content);
            FileUtils.writeStringToFile(file, content, "UTF-8");
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void updateCurrentHash(String hash) {
        setFileContent("hash.txt", hash);
    }
    
    
    
    @Override
    public void updateDownloadedHash(String hash) {
        setFileContent("downloaded.txt", hash);
    }


    /*private void copyConfFile() {
        try {
            FileUtils.copyFile(new File("conf.pr"), new File(folderName + File.separator + "conf.pr"));
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }*/

    @Override
    public boolean updateFiles() {
        logger.info("backuping directory " + folderName);
        File dir = new File(folderName);
        File newName = new File(folderName + "_backup");

        if (dir.exists()) {
            if (dir.isDirectory()) {
                dir.renameTo(newName);
            }
        }
        try {
            unzip(folderName.concat(".zip"), "");
            //copyConfFile();
        } catch (IOException ex) {
            logger.error(ex.getMessage(),ex);
            logger.error("failed to unzip file");
            if (newName.exists()) {
                if (newName.isDirectory()) {
                    newName.renameTo(dir);
                }
            }

            //copyConfFile();
            return false;
        }

        return true;

    }


    public void unzip(String zipFilePath, String destDirectory) throws IOException {
        if (!destDirectory.isEmpty()) {
            destDirectory = destDirectory + File.separator;
        }
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));

        ZipEntry entry = zipIn.getNextEntry();
        while (entry != null) {
            String filePath = destDirectory + entry.getName();
            if (!entry.isDirectory()) {
                extractFile(zipIn, filePath);
            } else {
                File dir = new File(filePath);
                String s = dir.getAbsolutePath();
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
        new File(zipFilePath).delete();
    }

    /**
     * Extracts a zip entry (file entry)
     *
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

}
