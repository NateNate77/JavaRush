package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> second = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();

        FileOutputStream outputStream = new FileOutputStream(name1);
        FileInputStream firstFile = new FileInputStream(name1);
        FileInputStream inputStream1 = new FileInputStream(name2);

        byte[] buffer1 = new byte[firstFile.available()];
        int count1 = 0;
        while (firstFile.available() > 0) count1 = firstFile.read(buffer1);

        while (inputStream1.available() > 0){
            int data = inputStream1.read();
            second.add(data);
        }
        for(int i = 0; i < second.size();i++){
            outputStream.write(second.get(i));
        }
        outputStream.write(buffer1, 0, count1);

        inputStream1.close();
        firstFile.close();
        outputStream.close();


    }
}
