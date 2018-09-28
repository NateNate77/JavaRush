package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        FileReader reader = new FileReader(fileName1);
        FileWriter writer = new FileWriter(fileName2);

        BufferedReader readerBuff = new BufferedReader(reader);
        BufferedWriter writeNumber = new BufferedWriter(writer);

        while (readerBuff.ready()){

            String united = readerBuff.readLine();

            String allNumber = "";

            String[] s = united.split(" ");
            for (String st : s) {
                try {
                    long number = Long.parseLong(st);
                    allNumber += number + " ";
                }

                catch (NumberFormatException e){

                }
            }


            writeNumber.write(allNumber.trim());
            writeNumber.newLine();
        }

        reader.close();
        writer.close();
        readerBuff.close();
        writeNumber.close();
    }
}
