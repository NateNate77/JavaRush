package com.javarush.task.task13.task1327;

import java.util.ArrayList;
import java.util.List;

/* 
Репка
*/

public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }



/*    interface RepkaItem {
        void pull(Person n);

    }*/
}

/*public class Person implements RepkaItem {
    public String first;
    public String second;

    public Person(String first, String second){
        this.first = first;
        this.second = second;
    }
    public void pull(Person n){

        System.out.println(n.first + " за " + second);
    }

    public String getNamePadezh(){
        return  null;
    }

}*/
