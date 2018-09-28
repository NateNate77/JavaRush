package com.javarush.task.task14.task1408;

/**
 * Created by Admin on 11.12.2017.
 */
public class BelarusianHen extends  Hen{
    public  int getCountOfEggsPerMonth(){
        return 20;
    }
    String getDescription(){
        return  super.getDescription() + " Моя страна - " + Country.BELARUS +". " + "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
