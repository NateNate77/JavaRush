package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private  List<Path> foundFiles  = new ArrayList<>();



    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String fileName = file.getFileName().toString();
        String fileContent = new String(content);
        boolean flag = false;
        if(partOfName!=null){
            if(fileName.contains(partOfName)){
                flag = true;
            }
            else {
                return super.visitFile(file, attrs);
            }
           //foundFiles.add(file);

        }
        if(partOfContent!=null){
            if(fileContent.contains(partOfContent)){
                flag = true;
            }
            else {
                return super.visitFile(file, attrs);
            }
          //  foundFiles.add(file);

        }

        if(maxSize>0){
            if(content.length<maxSize){
                flag = true;
            }
            else {
                return super.visitFile(file, attrs);
            }

         //   foundFiles.add(file);

        }

        if(minSize>0){
            if(content.length>minSize){
                flag = true;
            }
            else {
                return super.visitFile(file, attrs);
            }
            // foundFiles.add(file);

        }
        if (flag){
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int min) {
        this.minSize = min;
    }

    public void setMaxSize(int max) {
        this.maxSize = max;
    }

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }
}
