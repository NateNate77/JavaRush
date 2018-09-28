package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import static java.util.Collections.sort;

public class Solution {
    public static void main(String[] args) throws IOException {
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

        ArrayList<String> nameArray = new ArrayList<>();
        double max = Integer.MIN_VALUE;
       // TreeMap<Double, String> sorted = new TreeMap<>();

        for(HashMap.Entry<String, Double> pair : array.entrySet()){
           // String key = pair.getKey();
            double value = pair.getValue();
            if(value> max){
                max = value;

            }

        }

        for(HashMap.Entry<String, Double> pair : array.entrySet()){
            String key = pair.getKey();
            double value = pair.getValue();
            if(value == max){
                nameArray.add(key);
            }
        }
        sort(nameArray);

        for(String nameMax : nameArray){
            System.out.println(nameMax);
        }



        fileReader.close();
        reader.close();
    }
}
