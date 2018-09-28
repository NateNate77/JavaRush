package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()){
            String read = reader.readLine();
            String[] word = read.split(" ");
            int count = 0;
            for (int i = 0; i< words.size(); i++){
                for (int j = 0; j < word.length; j++){
                    if(words.get(i).equals(word[j])){
                        count++;
                        if(count>2){
                           // System.out.println();
                            break;
                        }
                    }
                }
            }
            if(count ==2){
                System.out.println(read);
            }
        }

        br.close();
        fileReader.close();
        reader.close();

    }
}
