package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        String name = url.getPath();
        String [] nameChapter = name.split("/");
       // String [] prefixSuffix = nameChapter[nameChapter.length-1].split("\\.");
        String prefix = nameChapter[nameChapter.length-1].substring(0, nameChapter[nameChapter.length-1].lastIndexOf("."));
        String suffix = nameChapter[nameChapter.length-1].substring(nameChapter[nameChapter.length-1].indexOf("."));

        Path tempFile = Files.createTempFile(prefix, suffix);
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
//        Files.move(tempFile, downloadDirectory, StandardCopyOption.REPLACE_EXISTING);
//        return tempFile;
        Path dowloadedFile = Paths.get(downloadDirectory + "/" + prefix+ suffix); //создали Path - куда будем перемещать
        Files.move(tempFile, dowloadedFile); //перемещаем
        return dowloadedFile;
    }
}
//
//    String fileName = urlString.substring(urlString.lastIndexOf("/") + 1); //получили имя файла из ссылки
//    Path dowloadedFile = Paths.get(downloadDirectory + "/" + fileName); //создали Path - куда будем перемещать
//Files.move(tempFile, dowloadedFile); //перемещаем
//        return dowloadedFile; //об этом надо догадаться по смыслу