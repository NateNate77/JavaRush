package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        String name = args[0];


        FileReader fileReader = new FileReader(name);
        BufferedReader reader = new BufferedReader(fileReader);



        while (reader.ready()) {
            String read = reader.readLine();
            String[] arrayString = read.split(" ");

           String day = arrayString[(arrayString.length-3)];
           String month = arrayString[(arrayString.length-2)];
           String year = arrayString[(arrayString.length-1)];
           String dates = day + " " + month + " " + year;
            String names = "";
           for(int i = 0; i < arrayString.length-3; i++){
              names += arrayString[i] + " ";
           }

            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");//задаю формат даты
            Date date = formatter.parse(dates);

            Person person = new Person(names.trim(), date);
            PEOPLE.add(person);


        }

        fileReader.close();
        reader.close();

    }
}
