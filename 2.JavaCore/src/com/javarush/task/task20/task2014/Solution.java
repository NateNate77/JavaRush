package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream("C:\\a.txt");
        FileOutputStream fileOutput = new FileOutputStream("C:\\a.txt");
        Solution savedObject = new Solution(56);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(savedObject);
        fileOutput.close();
        outputStream.close();
        Solution anotherObject = new Solution(77);
        ObjectInputStream objectStream = new ObjectInputStream(fileInput);
        Object loadedObject = objectStream.readObject();
        Solution newLoadedObject = (Solution) loadedObject;
        fileInput.close();
        objectStream.close();

        if(savedObject.string.equals(newLoadedObject.string)){
            System.out.println("ok!");
        }


        System.out.println(new Solution(4));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
