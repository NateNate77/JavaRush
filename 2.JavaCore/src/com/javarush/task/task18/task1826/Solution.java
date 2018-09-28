package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String indicator = args[0];
        String name = args[1];
        String newName = args[2];

        FileInputStream inputStream = new FileInputStream(name);
        FileOutputStream outputStream = new FileOutputStream(newName);

        if(indicator.equals("-e")){
            while (inputStream.available() > 0){
                int data = inputStream.read();
                int newData = data+10;
                outputStream.write(newData);
            }
        }
        else if(indicator.equals("-d")){
            while (inputStream.available() > 0){
                int data = inputStream.read();
                int newData = data-10;
                outputStream.write(newData);
            }
        }

        inputStream.close();
        outputStream.close();

    }

}
