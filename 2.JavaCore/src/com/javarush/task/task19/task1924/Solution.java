package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(name);
        BufferedReader br = new BufferedReader(fileReader);

        while (br.ready()){
            String line = br.readLine();
            String[] lineNew = line.split(" ");
            String result = "";
            for(int i = 0; i<lineNew.length; i++){
                try{
                    int number = Integer.parseInt(lineNew[i]);
                    if(map.containsKey(number)){
                        String value = map.get(number);
                        result+= value + " ";
                    }
                    else {
                        result+= lineNew[i]+" ";
                    }
                }
                catch (Exception e){
                    result+=lineNew[i] + " ";
                }
            }

            System.out.println(result.trim());

        }

        fileReader.close();
        br.close();

    }
}
