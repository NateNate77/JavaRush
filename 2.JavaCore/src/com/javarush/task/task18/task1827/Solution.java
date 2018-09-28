package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        if(args.length == 0){
            return;
        }

        int max = 0;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        FileOutputStream outputStream = new FileOutputStream(name, true);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String id = line.substring(0,8);
            int idInt = Integer.parseInt(id.trim());

            if(idInt>max){
                max=idInt;
            }

        }

        int newId = max+1;

        String idStr = String.valueOf(newId);
        if(idStr.length()<8){
            while ((8-idStr.length())>0){
                idStr+=" ";
            }
        }

        String productName = args[1];
        if(productName.length()<30){
            while (30-productName.length()>0){
                productName+= " ";
            }
        }
        else{
            productName = productName.substring(0,30);
        }

        String price = args[2];
        if(price.length()<8){
            while (8-price.length()>0){
                price+= " ";
            }
        }
        else {
            price = price.substring(0,8);
        }

        String quantity = args[3];
        if(quantity.length()<4){
            while (4-quantity.length() > 0){
                quantity+= " ";
            }
        }
        else{
            quantity = quantity.substring(0,4);
        }

        String result = "\n" + idStr + productName + price + quantity;

        outputStream.write(result.getBytes());

        inputStream.close();
        outputStream.close();


    }
}
