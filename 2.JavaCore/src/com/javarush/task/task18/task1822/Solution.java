package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();

        FileInputStream inputStream = new FileInputStream(name1);
        int id = Integer.parseInt(args[0]);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            int currentId = Integer.parseInt(array[0]);
            if(currentId == id){
                System.out.println(array[0] + " " + array[1] + " " + array[2] + " " + array[3]);
            }
        }

        inputStream.close();
    }
}
