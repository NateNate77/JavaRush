package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileReader reader = new FileReader(fileName);
        String united = "";
        while (reader.ready()){
            int data = reader.read();
            united += (char) data;

        }

        int count = 0;
            String[] s = united.split("\\W");
            for (String st : s) {
                if (st.equals("world")) count++;
            }




        System.out.println(count);
        reader.close();
    }
}
