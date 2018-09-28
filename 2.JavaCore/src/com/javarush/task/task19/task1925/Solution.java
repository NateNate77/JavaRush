package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String name1 = args[0];
        String name2 = args[1];

        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);

        BufferedReader reader = new BufferedReader(fileReader);
        String result = "";
        while (reader.ready()){

            String line = reader.readLine();
            String[] lineNew = line.split(" ");
            for (int i = 0; i< lineNew.length; i++){
               if(lineNew[i].length()>6){
                   result += lineNew[i]+",";
               }
            }

        }
        //reader.close();
        fileReader.close();
        String resultFinal = result.substring(0, result.length()-1);
        fileWriter.write(resultFinal);



        fileWriter.close();


    }
}
