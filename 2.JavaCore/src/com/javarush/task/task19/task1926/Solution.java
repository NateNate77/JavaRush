package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        br.close();

        FileReader fileReader = new FileReader(name);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()){
            String line = reader.readLine();
            String result = "";
            for(int i = line.length()-1; i > -1; i--){
                result+= line.charAt(i);
            }
            System.out.println(result);
        }
        fileReader.close();

    }
}
