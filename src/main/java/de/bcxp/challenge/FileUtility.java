package de.bcxp.challenge;

import java.io.File;
import java.io.IOException;

public class FileUtility {
    public FileUtility() {}

    public static boolean isFileDesiredType(String fileName, String fileType) {
        try {
            return getFileExtension(fileName) == fileType;
        } catch (IOException e) { e.printStackTrace();}
        return false;
    }

    public static String getFileExtension(String fullName) throws IOException {
        if(!checkIfFileExists(fullName)) throw new IOException();
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public static boolean checkIfFileExists(String fileName) {
        return fileName != null && !fileName.isEmpty();
    }
}
