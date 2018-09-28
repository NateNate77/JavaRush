package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();
        String name3 = br.readLine();


        FileOutputStream outputStream = new FileOutputStream(name1, true);
        FileInputStream inputStream1 = new FileInputStream(name2);
        FileInputStream inputStream2 = new FileInputStream(name3);

        byte[] buffer1 = new byte[inputStream1.available()];
        byte[] buffer2 = new byte[inputStream2.available()];
        int count1 = 0;
        int count2 = 0;

        while (inputStream1.available() > 0) count1 = inputStream1.read(buffer1);
        while (inputStream2.available() > 0) count2 = inputStream2.read(buffer2);

        inputStream1.close();
        inputStream2.close();

        outputStream.write(buffer1, 0, count1);
        outputStream.write(buffer2, 0, count2);
        outputStream.close();


    }
}
