package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {


      //  if(n==0){
     //       return "1";
     //   }

      //   if(n>0){
            //double result = 1;
           // for (int i = 2; i <= n; i++) {
           //     result *= i;
          //  }
          //  String str = Double.toString(result);
         //   return str;

            // BigInteger I=BigInteger.ONE;
            // for(int i=1;i<n;i++)I=I.multiply(BigInteger.valueOf(i));
           //  return I.toString();

             if (n < 0) return  String.valueOf(BigInteger.ZERO);
             if (n == 0) return  String.valueOf(BigInteger.ONE);
             BigInteger multiplier = new BigInteger(factorial(n-1));
             BigInteger result = BigInteger.valueOf(n).multiply(multiplier);
             return String.valueOf(result);



        }


       // return "0";
    }

