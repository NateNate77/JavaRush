package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Admin on 23.01.2018.
 */
public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes tip){

        if(tip==null){
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        switch (tip){

            case BMP:
                return new BmpReader();

            case JPG:
                return new JpgReader();

            case PNG:
                return new PngReader();

            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");

        }
    }
}
