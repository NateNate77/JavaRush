package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]){
            case "-c" :

                synchronized (allPeople){
                    for(int i = 1; i<args.length; i = i+3){
                        Date date = new Date();
                        try {
                            date = format.parse(args[i+2]);
                        } catch (ParseException e) {
                            // e.printStackTrace();
                        }

                        if(args[i+1].equals("м")){
                            allPeople.add(Person.createMale(args[i], date));
                        }
                        else {
                            allPeople.add(Person.createFemale(args[i], date));
                        }
                        System.out.println(allPeople.size()-1);
                    }
                }


                break;

            case "-u" :

                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        Person dude = allPeople.get(Integer.parseInt(args[i]));
                        dude.setName(args[i + 1]);
                        dude.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                        Date date = new Date();
                        try {
                            date = format.parse(args[i + 3]);
                        } catch (ParseException e) {
                            // e.printStackTrace();
                        }
                        dude.setBirthDay(date);
                    }
                }
                break;

            case "-d" :

                synchronized (allPeople) {

                    for (int i = 1; i < args.length; i++) {
                        Person dude = allPeople.get(Integer.parseInt(args[i]));
                        dude.setName(null);
                        dude.setSex(null);
                        dude.setBirthDay(null);
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person dude = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(dude.getName());
                        System.out.println(dude.getSex() == Sex.MALE ? "м" : "ж");
                        System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(dude.getBirthDay()));
                    }
                }

                break;

        }

    }
}
