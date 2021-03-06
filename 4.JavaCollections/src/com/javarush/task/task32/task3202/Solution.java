package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (br.ready()){
                String line = br.readLine();
                writer.write(line);
            }
        }
        catch (Exception e){

        }


        return writer;
    }
}