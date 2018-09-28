package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        while (line!=null){

            try{
                FileInputStream inputStream = new FileInputStream(line);
                while (inputStream.available() > 0){
                    int data = inputStream.read();
                }
                inputStream.close();

            }

            catch (FileNotFoundException e){
                System.out.println(line);

                break;
            }
            line = br.readLine();
        }
    }
}
