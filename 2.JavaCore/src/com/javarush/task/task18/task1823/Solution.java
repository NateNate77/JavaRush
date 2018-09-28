package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && !line.equals("exit")){

           ReadThread readFile =  new ReadThread(line);
           readFile.start();
           line = br.readLine();
        }

    }

    public static class ReadThread extends Thread {
        private String name;
        HashMap<Integer, Integer> array = new HashMap<Integer, Integer>();
        int max = 0;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.name = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run(){


            try {
                FileInputStream inputStream = new FileInputStream(name);
                while (inputStream.available() > 0){
                    int data = inputStream.read();
                    if(array.containsKey(data)){
                        int value = array.get(data);
                        value++;
                        array.put(data, value);
                    }
                    else{
                        array.put(data, 1);
                    }



                }

                inputStream.close();
            }

            catch (IOException e) {
                //e.printStackTrace();
            }

            for(HashMap.Entry<Integer, Integer> pair : array.entrySet()){

                int value = pair.getValue();
                if(value>max){
                    max  = value;
                }
            }

            for(HashMap.Entry<Integer, Integer> pair : array.entrySet()){
                int value = pair.getValue();
                if(value==max){
                    int key = pair.getKey();
                    Solution.resultMap.put(name, key);
                }
            }

        }





    }
}
