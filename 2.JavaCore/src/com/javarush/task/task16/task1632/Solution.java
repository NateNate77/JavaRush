package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {

            ThreadNumber1 a = new ThreadNumber1();
            threads.add(a);
            ThreadNumber2 b = new ThreadNumber2();
            threads.add(b);
            ThreadNumber3 c = new ThreadNumber3();
            threads.add(c);
            ThreadNumber4 d = new ThreadNumber4();
            threads.add(d);
            ThreadNumber5 e = new ThreadNumber5();
            threads.add(e);
        }


    public static void main(String[] args) {
       // for(int i = 0; i<Solution.threads.size(); i++){
       //     Solution.threads.get(i).start();
       // }
    }

    public static class NewThread extends Thread {
      //  String name;
      //  public NewThread(String nameThread){
      //          this.name = nameThread;
      //      super(nameThread);
       // }
    }

    public static class ThreadNumber1 extends NewThread {
        public void run(){
            while (true){

            }
        }
    }
    public static class ThreadNumber2 extends NewThread {

        public void run() {
            try {
               sleep(2000000);

            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }

        }

    }
    public static class ThreadNumber3 extends NewThread {

        public void run(){
            try {
                while (true){

                    System.out.println("Ура");
                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    public static class ThreadNumber4 extends NewThread implements Message {


        @Override
        public void showWarning() {
            if(isAlive()){
                stop();
            }

        }

        public void run(){
            while (true){

            }
        }
    }
    public static class ThreadNumber5 extends NewThread {

        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int result = 0;

            while (true){
                try {
                    String number = reader.readLine();
                    if(number.equals("N")){
                        break;
                    }
                    else if(!number.isEmpty()){
                        int n = Integer.parseInt(number);
                        result += n;
                    }
                } catch (IOException e) {
                  //  e.printStackTrace();
                }


            }
            System.out.println(result);

        }

    }

}