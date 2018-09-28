package com.javarush.task.task15.task1530;

/**
 * Created by Admin on 08.01.2018.
 */
public abstract class DrinkMaker {

    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }

    public abstract void getRightCup();

    public abstract void putIngredient();

    public abstract void pour();


}
