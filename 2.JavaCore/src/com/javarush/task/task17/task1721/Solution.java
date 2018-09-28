package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String firstFileName;
    public static String secondFileName;
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String a = reader.readLine();
            String b = reader.readLine();
            firstFileName = a;
            secondFileName = b;
        }
        catch (Exception e){

        }
        try {
            FileInputStream fstream = new FileInputStream(firstFileName);
            FileInputStream sStream = new FileInputStream(secondFileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(sStream));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                allLines.add(strLine);

            }
            fstream.close();
            while ((strLine = br2.readLine()) != null) {
                forRemoveLines.add(strLine);

            }
            sStream.close();

        }
        catch (Exception e){

        }

    }

    public static void main(String[] args) {
        Solution one = new Solution();
        try {
            one.joinData();
        } catch (CorruptedDataException e) {
          //  e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {



        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
            throw new CorruptedDataException();
        }




    }
}
