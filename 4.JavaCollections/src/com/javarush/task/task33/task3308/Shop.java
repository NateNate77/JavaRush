package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 13.06.2018.
 */
@XmlType(name = "Shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData = new String[5];

    public void arrayFill(){
        for(int i = 0; i<5; i++){
            secretData[i] = String.valueOf(i);
        }
    }
    @XmlType(name = "Goods")
    @XmlRootElement
    public static class Goods{
        List<String> names = new ArrayList<>();

        public void listFill(){
            names.add("a");
            names.add("b");
            names.add("c");
        }

    }
}
