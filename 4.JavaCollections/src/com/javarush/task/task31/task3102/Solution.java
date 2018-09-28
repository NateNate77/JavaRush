package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> files = new PriorityQueue<>();
        ArrayList<String> list = new ArrayList<>();
        File file = new File(root);
        files.add(file);
        while (!files.isEmpty()){
            File currentRoot = files.remove();
            for(File currentFile : currentRoot.listFiles()){
                if(currentFile.isDirectory()){
                    files.add(currentFile);
                }
                else {
                    list.add(currentFile.getAbsolutePath());
                }
            }
        }


        return list;

    }

    public static void main(String[] args) {
        
    }
}
