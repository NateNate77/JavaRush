package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {


      //  String result = "";
        HashMap<Integer, Integer> array = new HashMap<Integer, Integer>();

        FileInputStream inputStream = new FileInputStream(args[0]);

        while (inputStream.available() > 0){
            int data = inputStream.read();
            if(array.containsKey(data)){
                int value = array.get(data);
                value++;
                array.put(data, value);
            }
            else{
                array.put(data, 1);
            }

        }

        TreeMap<Integer, Integer> sorted = new TreeMap<>(array);

        for(int key : sorted.keySet()){
            char stringKey = (char) key;
            System.out.println(stringKey + " " + String.valueOf(sorted.get(key)));

        }

        inputStream.close();


    }
}
