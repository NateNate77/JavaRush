package com.javarush.task.task17.task1710;

import javafx.scene.input.DataFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // String str="";
        //try {
       //     str = reader.readLine();
       // } catch (IOException e) {
       //     //e.printStackTrace();
      //  }
        //String[] args = str.split(" ");

        if(args[0].equals("-c")){
             DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
             Date date1= new Date();
            try {
                date1 = format.parse(args[3]);
            } catch (ParseException e) {
               // e.printStackTrace();
            }

            if(args[args.length-2].equals("м")){
                allPeople.add(Person.createMale(args[1], date1));
            }
            else {
                allPeople.add(Person.createFemale(args[1], date1));
            }
            System.out.println(allPeople.size()-1);




        }

        if(args[0].equals("-u")){
           Person dude = allPeople.get(Integer.parseInt(args[1]));
           dude.setName(args[2]);
           dude.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date= new Date();
            try {
                date = format.parse(args[4]);
            } catch (ParseException e) {
                // e.printStackTrace();
            }
           dude.setBirthDay(date);

           }

        if(args[0].equals("-d")){


                Person dude = allPeople.get(Integer.parseInt(args[0]));
                dude.setName(null);
                dude.setSex(null);
                dude.setBirthDay(null);



        }

        if (args[0].equals("-i")){
            Person dude = allPeople.get(Integer.parseInt(args[1]));
            System.out.println(dude.getName());
            System.out.println(dude.getSex()==Sex.MALE ? "м" : "ж");
            System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(dude.getBirthDay()));
        }

    }
}
