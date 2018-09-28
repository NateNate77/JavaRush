package com.javarush.task.task20.task2026;

import java.util.ArrayList;
import java.util.HashSet;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
//        int i = 0;
//        int j = 0;
//        for(int i = 0; i<a.length; i++){
//            for(int j = 0; j<a.length; j++){
//                if(a[i][j]==1){
//
//                }
//            }
//        }

//        while (a[i][j]<1){
//            j++;
//        }
//        int startJ = j;
//        while (a[i][j]>0){
//            j++;
//        }
//        int startI = i;
//        while (a[i][startJ]>0){
//            i++;
//        }
        HashSet<String> excluded = new HashSet<>();
        for(int i = 0; i<a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0)
                    continue;

                String coordinates = String.valueOf(i) + " " + String.valueOf(j);
                if (excluded.contains(coordinates))
                    continue;

                count++;

                int endJ = j;

                while (endJ < a[i].length && a[i][endJ] > 0)
                    endJ++;


                int endI = i;

                while (endI < a.length && a[endI][j] > 0) {
                    endI++;
                }

                for (int excI = i; excI < endI; excI++)
                {
                    for (int excJ = j; excJ < endJ; excJ++)
                    {
                        String newCoordinates = String.valueOf(excI) + " " + String.valueOf(excJ);
                        excluded.add(newCoordinates);
                    }

                }
            }
        }
        return count;
    }
}
