package com.javarush.task.task14.task1421;

/**
 * Created by Admin on 18.12.2017.
 */
public class Singleton {
    private static Singleton instance;
    public static Singleton getInstance(){
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
    private Singleton(){

    }
}
