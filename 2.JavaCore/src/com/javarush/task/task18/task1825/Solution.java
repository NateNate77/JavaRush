package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, byte[]> names = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String nameFile = line.substring(0,line.indexOf(".part"));
        FileOutputStream outputStream = new FileOutputStream(nameFile);
        while (line!= null && !line.equals("end")){
            FileInputStream inputStream = new FileInputStream(line);
            String[] name = line.split("\\.");
            String part = name[name.length-1];

            byte[] buffer1 = new byte[inputStream.available()];

            while (inputStream.available() > 0)  inputStream.read(buffer1);

            names.put(part, buffer1);

            line = br.readLine();

            inputStream.close();
        }

       for(int i = 1; i<= names.size(); i++){
            byte[] value = names.get("part" + i);
            outputStream.write(value);
       }
       outputStream.close();


    }
}
