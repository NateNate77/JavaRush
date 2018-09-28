package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        String number = args[1];
        String text = args[2];

        int numberInt = Integer.parseInt(number);
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        if(raf.length()-numberInt<text.length()){
            raf.seek(raf.length());
            raf.write(text.getBytes());
        }
        else {
            raf.seek(numberInt);
            raf.write(text.getBytes());
        }

    }
}
