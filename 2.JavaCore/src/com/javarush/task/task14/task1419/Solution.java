package com.javarush.task.task14.task1419;

import javax.naming.LinkException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        IOException a = new IOException();
        exceptions.add(a);
        FileNotFoundException b = new FileNotFoundException();
        exceptions.add(b);
        IndexOutOfBoundsException c = new IndexOutOfBoundsException();
        exceptions.add(c);
        ArrayIndexOutOfBoundsException d = new ArrayIndexOutOfBoundsException();
        exceptions.add(d);
        SocketException f = new SocketException();
        exceptions.add(f);
        NullPointerException g = new NullPointerException();
        exceptions.add(g);

        LinkException h = new LinkException();
        exceptions.add(h);
        NumberFormatException i = new NumberFormatException();
        exceptions.add(i);
        EmptyStackException j = new EmptyStackException();
        exceptions.add(j);
    }
}
