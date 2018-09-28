package com.javarush.task.task14.task1417;

/**
 * Created by Admin on 18.12.2017.
 */
public class Hrivna extends Money {
    @Override
    public String getCurrencyName(){
        return "HRN";
    }
    public Hrivna(double amount) {
        super(amount);
    }
}
