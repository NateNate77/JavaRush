package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileReader fileReader1 = new FileReader(name1);
        FileReader fileReader2 = new FileReader(name2);
        BufferedReader br1 = new BufferedReader(fileReader1);
        BufferedReader br2 = new BufferedReader(fileReader2);
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();


        while (br1.ready()){
        String line = br1.readLine();
        file1.add(line);
        }

        while (br2.ready()){
            String line = br2.readLine();
            file2.add(line);
        }
        int j = 0;

       // int maxSize;
      //  if(file1.size()>=file2.size()){
     //       maxSize = file1.size();
      //  }
     //   else {
     //       maxSize = file2.size();
      //  }

        for (int i = 0; i < file1.size(); i++){
            if(j<file2.size() && file1.get(i).equals(file2.get(j))){
                LineItem lineSame = new LineItem(Type.SAME, file1.get(i));
                lines.add(lineSame);
                j++;
            }
            else if(j< file2.size()-1 && file1.get(i).equals(file2.get(j+1))){
                LineItem lineAdded = new LineItem(Type.ADDED, file2.get(j));
                lines.add(lineAdded);
                j++;
                i--;
            }
            else {
                LineItem lineRemoved = new LineItem(Type.REMOVED, file1.get(i));
                lines.add(lineRemoved);


            }

        }

        for( int a = j ; a< file2.size(); a++){
            LineItem lineline = new LineItem(Type.ADDED, file2.get(a));
            lines.add(lineline);
        }

        fileReader1.close();
        fileReader2.close();
       // br1.close();
       // br2.close();

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
