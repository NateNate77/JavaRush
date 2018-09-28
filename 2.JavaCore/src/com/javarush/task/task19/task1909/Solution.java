package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        FileReader reader = new FileReader(fileName1);
        FileWriter writer = new FileWriter(fileName2);

        BufferedReader readerBuff = new BufferedReader(reader);
        BufferedWriter writeBuff = new BufferedWriter(writer);

        String united = "";

        while (readerBuff.ready()){

            united += readerBuff.readLine() + "\n";

        }

        String newUnited = united.replaceAll("\\.", "!");

        writeBuff.write(newUnited);


        reader.close();
        writer.close();
        readerBuff.close();
        writeBuff.close();
    }
}
