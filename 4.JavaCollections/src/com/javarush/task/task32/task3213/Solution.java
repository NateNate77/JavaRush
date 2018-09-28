package com.javarush.task.task32.task3213;

import java.io.*;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String line = "";
        int b;
        try{
            do {
                b = reader.read();
                if (b!=-1){
                    int newB = b+key;
                    line += (char) newB;
                }

            } while (b != -1);
        }
        catch (Exception e){

        }
        return line;
    }
}
