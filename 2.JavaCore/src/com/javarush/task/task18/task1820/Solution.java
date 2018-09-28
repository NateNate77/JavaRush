package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> array = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();


        FileInputStream inputStream1 = new FileInputStream(name1);
        FileOutputStream outputStream = new FileOutputStream(name2);

        try (BufferedReader br2 = new BufferedReader(new FileReader(name1))) {
            String line;
            while ((line = br2.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String a : numbers){
                    float number = Float.parseFloat(a);
                    int numberInt = Math.round(number);
                    array.add(numberInt);
                }
            }
        }

        for (int i = 0; i < array.size(); i++){
            String stringNumber = String.valueOf(array.get(i)) + " ";
            outputStream.write(stringNumber.getBytes());
        }

        inputStream1.close();
        outputStream.close();

    }
}
