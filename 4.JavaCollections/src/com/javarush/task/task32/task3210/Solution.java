package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        String number = args[1];
        String text = args[2];

        int numberInt = Integer.parseInt(number);
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(numberInt);
        byte[] b = new byte[text.length()];
        int textRead = raf.read(b, 0, text.length());
        String textString = new String(b);
        raf.seek(raf.length());
        if(textString.equals(text)){

            raf.write("true".getBytes());
        }
        else {
            raf.write("false".getBytes());
        }




    }
}
