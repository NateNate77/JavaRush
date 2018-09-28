package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> array = new ArrayList<>();

        if(args.length == 0){
            return;
        }

        String idCrud = args[1];
        int idCrudInt = Integer.parseInt(idCrud);
        String change = args[0];
        String line;
        String productNameNew = "";
        String priceNew = "";
        String quantityNew = "";


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        FileOutputStream outputStream = new FileOutputStream(name, true);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            array.add(line);

        }

        inputStream.close();

        if(args.length > 2){

            productNameNew = args[2];
            if(productNameNew.length()<30){
                while (30-productNameNew.length()>0){
                    productNameNew+= " ";
                }
            }
            else{
                productNameNew = productNameNew.substring(0,30);
            }

            priceNew = args[3];
            if(priceNew.length()<8){
                while (8-priceNew.length()>0){
                    priceNew+= " ";
                }
            }
            else {
                priceNew = priceNew.substring(0,8);
            }

            quantityNew = args[4];
            if(quantityNew.length()<4){
                while (4-quantityNew.length() > 0){
                    quantityNew+= " ";
                }
            }
            else{
                quantityNew = quantityNew.substring(0,4);
            }
        }


        int upDate = 0;
        String idRecord = "";

        for(int i = 0; i<array.size(); i++) {
            String stringArray = array.get(i);

            String id = stringArray.substring(0, 8);
            int idInt = Integer.parseInt(id.trim());
            // String productName = stringArray.substring(8, 38);
            // String price = stringArray.substring(38, 46);
            //  String quantity = stringArray.substring(46, 50);

            if (idInt == idCrudInt) {
               idRecord = id;

               upDate = i;

            }
        }

        String newString = idRecord + productNameNew + priceNew + quantityNew;

            if(change.equals("-u")){

                array.set(upDate, newString);
            }
            else if(change.equals("-d")){
                array.remove(upDate);
            }

            for (String data : array){
                String result = data + "\n";
                outputStream.write(result.getBytes());
            }


        outputStream.close();


    }
}
