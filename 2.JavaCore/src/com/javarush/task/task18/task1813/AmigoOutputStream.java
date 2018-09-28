package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream a;
    public AmigoOutputStream (FileOutputStream c) throws FileNotFoundException {
        super(fileName);
        a = c;

    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void flush() throws IOException {
        a.flush();
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        a.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        a.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        a.write(b);
    }



    @Override
    public void close() throws IOException {
        a.flush();
        String data = "JavaRush © All rights reserved.";
        a.write(data.getBytes());
        a.close();
    }
}
