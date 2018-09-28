package com.javarush.task.task31.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Своя реализация
*/
public class Solution {
    public static byte[] readBytes(String fileName) throws IOException {
        byte[] contains = Files.readAllBytes(Paths.get(fileName));

        return contains;
    }

    public static List<String> readLines(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
//        FileInputStream fileInputStream = new FileInputStream(fileName);
//        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
//        while (fileInputStream.available()>0){
//            String line = br.readLine();
//            lines.add(line);
//
//        }


        return lines;
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
//        bw.write(String.valueOf(bytes));

        Files.write(Paths.get(fileName), bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));

    }
}
