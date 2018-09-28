package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        int c = n.indexOf('?');
        String result = "";
        String objValue = "";
        for(c += 1; c<n.length(); c++){
            if(!n.substring(c,c+1).equals("&")){
                 result += n.substring(c, c+1);


            }
            else{
                if(result.length() > 4 && result.substring(0,4).equals("obj=")){
                    objValue = result.substring(4,result.length());

                }
                if(result.indexOf('=')>=0){
                    result = result.substring(0,result.indexOf('='));
                }
                System.out.print(result + " ");
                result = "";
            }

        }

        if(result.length() > 4 && result.substring(0,4).equals("obj=")){
            objValue = result.substring(4,result.length());

        }

        if(result.indexOf('=')>=0){
            result = result.substring(0,result.indexOf('='));
        }
        System.out.println(result);

        if(!objValue.equals("")){
            try{
                double a = Double.parseDouble(objValue);
                alert(a);

            }
            catch(Exception e){
                alert(objValue);
            }
        }





    }

    public static void alert(double value) {

        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
