package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        HashMap<String, Double> array = new HashMap<>();

        String name = args[0];


        FileReader fileReader = new FileReader(name);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()){
            String read = reader.readLine();
            String[] arrayString = read.split(" ");
            if(array.containsKey(arrayString[0])){
                double value = array.get(arrayString[0]);
                double newValue = value + Double.parseDouble(arrayString[1]);
                array.put(arrayString[0], newValue);
            }
            else{
                array.put(arrayString[0], Double.parseDouble(arrayString[1]));
            }
        }

        TreeMap<String, Double> sorted = new TreeMap<>(array);

        for(HashMap.Entry<String, Double> pair : array.entrySet()){
            String key = pair.getKey();
            double value = pair.getValue();

            sorted.put(key, value);

        }

        for(String keyName : sorted.keySet()){


            System.out.println(keyName + " " + String.valueOf(sorted.get(keyName)));
        }



        fileReader.close();
        reader.close();
    }
}
