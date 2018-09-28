package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countSign = 0;
        int countSpace = 0;
        FileInputStream inputStream = new FileInputStream(args[0]);

        while (inputStream.available() > 0){
            int data = inputStream.read();
            countSign++;
            if(data == 32){
                countSpace++;
            }
        }

        double ratio = ((double) countSpace/countSign)*100;
        String ratioString = String.format("%.2f", ratio);

        inputStream.close();
        System.out.println(ratioString);

    }
}
