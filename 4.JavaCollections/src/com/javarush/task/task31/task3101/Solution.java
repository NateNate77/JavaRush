package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Collections.sort;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<File> list = new ArrayList<>();
        String path = args[0];
        String fileName = args[1];
        File sourceFile = new File(fileName);
        File resultFile = new File(sourceFile.getParent() + "/allFilesContent.txt");
        File pathFile = new File(path);
        if(FileUtils.isExist(sourceFile)){
            FileUtils.renameFile(sourceFile, resultFile);
        }
        readFiles(list, pathFile);

        Collections.sort(list, new LexicographicComparator());




      //  FileInputStream fileInputStream = new FileInputStream()

        FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
        for(File file : list){
            FileInputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[50];
            int count = inputStream.read(buffer);
            fileOutputStream.write(buffer, 0, count);
            fileOutputStream.write("\n".getBytes());
            inputStream.close();
        }

        fileOutputStream.close();

    }
    private static void readFiles(ArrayList<File> list, File pathFile){
        for(File file : pathFile.listFiles()){
            if(file.isDirectory()){
                readFiles(list, file);
            }
            else {
                long lengthFile = file.length();
                if(lengthFile<=50){
                    list.add(file);
                }
            }

        }
    }


    static class LexicographicComparator implements Comparator<File> {
        @Override
        public int compare(File a, File b) {
            return a.getName().compareToIgnoreCase(b.getName());
        }
    }
}
