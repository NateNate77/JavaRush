package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        
        PrintStream consoleStream = System.out;
 
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
 
    PrintStream stream = new PrintStream(outputStream);
 
    System.setOut(stream); 

    testString.printSomething(); 

    String result = outputStream.toString();

    System.setOut(consoleStream);

    String[] stringNew = result.split(" ");
    int a = Integer.parseInt(stringNew[0]);
    int b = Integer.parseInt(stringNew[2]);
    int c = 0;

    switch (stringNew[1]){
        case "+" :
            c = a+b;
            break;
        case "-" :
            c = a-b;
            break;
        case "*" :
            c = a*b;
            break;

    }

 
    System.out.println(stringNew[0] + " " + stringNew[1] + " " + stringNew[2] + " " + stringNew[3] + " " + c);
    }
    

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

