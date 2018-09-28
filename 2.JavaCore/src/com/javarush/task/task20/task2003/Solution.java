package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        load(inputStream);


    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, null);
        //implement this method - реализуйте этот метод
      //  for(Map.Entry<String, String> pair : properties.entrySet()){
      //      String key = pair.getKey();
      //      String keyString = key + "\n";
      //      String value = pair.getValue();
      //      String valueSttring = value + "\n";
      //      outputStream.write(keyString.getBytes());
      //      outputStream.write(valueSttring.getBytes());

       // }

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);

        properties.putAll((Map)prop);
//        Scanner scanner = new Scanner(inputStream);
//        while (scanner.hasNextLine()){
//            String lineKey = scanner.nextLine();
//            String lineValue = scanner.nextLine();
//            prop.lo.setProperty(lineKey, lineValue);

     //   }



    }

    public static void main(String[] args) {

    }
}
