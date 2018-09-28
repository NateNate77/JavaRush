package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        while (true){
            key = reader.readLine();
            if(key.equals("user")){
                 person = new Person.User();
            }
            else if( key.equals("loser")){
                 person = new Person.Loser();
            }
            else if(key.equals("coder")){
                 person = new Person.Coder();
            }
            else if(key.equals("proger")){
                 person = new Person.Proger();
            }
            else {
                break;
            }
            doWork(person);
        }


    }

    public static void doWork(Person person) {
        if(person instanceof Person.User){
            Person.User person12 = (Person.User) person;
            person12.live();
        }
        if(person instanceof Person.Loser){
            Person.Loser person12 = (Person.Loser) person;
            person12.doNothing();
        }
        if(person instanceof Person.Coder){
            Person.Coder person12 = (Person.Coder) person;
            person12.coding();
        }
        if(person instanceof Person.Proger){
            Person.Proger person12 = (Person.Proger) person;
            person12.enjoy();
        }
    }
}
