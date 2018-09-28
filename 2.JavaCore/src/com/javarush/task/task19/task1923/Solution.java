package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String name1 = br.readLine();
        //String name2 = br.readLine();
        String name1 = args[0];
        String name2 = args[1];

        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);

        BufferedReader reader = new BufferedReader(fileReader);
       // BufferedWriter writer = new BufferedWriter(fileWriter);
        String result = "";

        while (reader.ready()){

            String line = reader.readLine();
            //String lineNew = line.replaceAll("[a-zA-Z]+\\d+\\w*|\\d+[a-zA-Z]+\\w*", " ");
           // Pattern p1 = Pattern. compile ("[a-zA-Zа-яА-Я]+\\d+\\w*|\\d+[a-zA-Zа-яА-Я]+\\w*");
            Pattern p1 = Pattern. compile ("[^\\s]*\\d+[^\\s]*");
           // Pattern p1 = Pattern. compile (".*\\d+.*");

            Matcher m2 = p1.matcher(line);
            while (m2.find()) {
                result+=m2.group() +" ";

            }

        }
        fileWriter.write(result);


        fileReader.close();
        fileWriter.close();
        reader.close();
        //writer.close();


    }
}
