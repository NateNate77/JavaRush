package com.javarush.task.task14.task1408;

/**
 * Created by Admin on 11.12.2017.
 */
public class RussianHen extends Hen{
    public  int getCountOfEggsPerMonth(){
        return 34;
    }
    String getDescription(){
        return  super.getDescription() + " Моя страна - " + Country.RUSSIA +". " + "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
