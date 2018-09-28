package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        FileInputStream inputStream = new FileInputStream(args[0]);
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if(data>64 && data<91 || data>96 && data<123){
                count++;
            }
        }

        inputStream.close();
        System.out.println(count);
    }
}
