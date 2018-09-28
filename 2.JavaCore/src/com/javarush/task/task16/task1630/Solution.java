package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String a = reader.readLine();
            String b = reader.readLine();
            firstFileName = a;
            secondFileName = b;
        } catch (IOException e) {
            // e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        String fileName;
        String result = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;

        }

        @Override
        public String getFileContent() {
            return result;
        }

        public void run(){
            try{
                FileInputStream fstream = new FileInputStream(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                while ((strLine = br.readLine()) != null){
                    result+= strLine + " ";
                }
            }catch (IOException e){
                // System.out.println("Ошибка");
            }


        }


    }
}
