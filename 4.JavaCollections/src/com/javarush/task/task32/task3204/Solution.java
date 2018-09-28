package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {

            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());

    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] b = new byte[8];
        b[0] = (byte) (48 + (int) (Math.random()*9));
        b[1] = (byte) (65 +(int)(Math.random()*25));
        b[2] = (byte) (97 + (int) (Math.random()*25));

        for (int i = 3; i < b.length; i++){
            int random = (int) (Math.random()*3);
            switch (random){
                case 0:
                    b[i] = (byte) (48 + (int) (Math.random()*9));
                    break;
                case 1:
                    b[i] = (byte) (65 +(int)(Math.random()*25));
                    break;
                case 2:
                    b[i] = (byte) (97 + (int) (Math.random()*25));
            }
        }
       for (byte h : b){
            byteArrayOutputStream.write(h);
       }
        return byteArrayOutputStream;
    }
}