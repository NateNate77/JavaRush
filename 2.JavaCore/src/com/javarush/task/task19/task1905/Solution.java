package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {

            for (Map.Entry<String, String> pair : countries.entrySet()){
                if(pair.getValue().equals(this.customer.getCountryName())){
                   return pair.getKey();
                }
            }

            return null;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String name = this.contact.getName();
            String[] nameData = name.split(",");
            String firstName = nameData[1].trim();
            return firstName;

        }

        @Override
        public String getContactLastName() {
            String name = this.contact.getName();
            String[] nameData = name.split(",");
            String lastName = nameData[0];
            return lastName;
        }

        @Override
        public String getDialString() {
            String number = this.contact.getPhoneNumber();
            String numberPhone = "callto://+" + number.substring(1,number.indexOf("(")) + number.substring(number.indexOf("(")+1,number.indexOf(")")) + number.substring(number.indexOf(")")+1,number.indexOf(")")+4) + number.substring(number.indexOf(")")+5,number.indexOf(")")+7) + number.substring(number.lastIndexOf("-")+1);
            return numberPhone;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}