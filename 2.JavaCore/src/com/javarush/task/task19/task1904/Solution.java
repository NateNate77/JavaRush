package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
           String person = this.fileScanner.nextLine();
           String[] personData = person.split(" ");

            String sd = personData[3] + "." + personData[4] + "." + personData[5];
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date date = format.parse(sd);

           return new Person(personData[1], personData[2], personData[0], date);
        }

        @Override
        public void close() throws IOException {

            this.fileScanner.close();

        }
    }
}
