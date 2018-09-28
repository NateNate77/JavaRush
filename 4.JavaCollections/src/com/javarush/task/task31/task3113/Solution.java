package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine();
//        Path nammeFille = Paths.get(name);
//        if(!Files.isDirectory(nammeFille)){
//            System.out.println(nammeFille.toString() + " - не папка");
//            return;
//        }
//        Queue<Path> files = new PriorityQueue<>();
//        files.add(nammeFille);
//        int countDirectory = 0;
//        int countFiles = 0;
//        long sizeFille = 0;
//
//        while (!files.isEmpty()){
//            Path currentRoot = files.remove();
//            for(Path currentFile : currentRoot.){
//                if(currentFile.isDirectory()){
//                    files.add(currentFile);
//                    countDirectory++;
//                }
//                else {
//                   countFiles++;
//                   sizeFille += currentFile.length();
//
//                }
//            }
//        }
//
//        System.out.println("Всего папок - " + countDirectory);
//        System.out.println( "Всего файлов - " + countFiles);
//        System.out.println("Общий размер - " + sizeFille);
        Path nammeFille = Paths.get(path);
        if(!Files.isDirectory(nammeFille)){
            System.out.println(nammeFille.toString() + " - не папка");
            return;
        }

        AtomicInteger directories = new AtomicInteger();
        AtomicInteger files = new AtomicInteger();
        final long[] size = {0};

        Files.walk(Paths.get(path))
                .forEach(f -> {
                    if (Files.isDirectory(f)) directories.getAndIncrement();
                    else {
                        files.getAndIncrement();
                        try {
                            size[0] += Files.size(f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

        System.out.println("Всего папок - " + directories.addAndGet(-1));
        System.out.println( "Всего файлов - " + files);
        System.out.println("Общий размер - " + size[0]);


    }
}
