package com.javarush.task.task14.task1416;

/* 
Исправление ошибок
*/

import com.sun.org.apache.xpath.internal.operations.Or;

public class Solution {
    public static void main(String[] args) {
        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimmable animal) {
        animal.swim();
    }

    interface Walkable {
        void walk();
    }

    interface Swimmable {
        void swim();
    }

    static abstract class OceanAnimal implements Swimmable {
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.swimming();
        }

        private void swimming() {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimmable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal {
        @Override
        Swimmable getCurrentAnimal() {
            Orca orca = new Orca();
            return orca;
        }
    }

    static class Whale extends OceanAnimal {
        @Override
        Swimmable getCurrentAnimal() {
            Whale whale = new Whale();
            return whale;
        }
    }

    static class Otter implements Walkable, Swimmable {
        public void walk(){

        }

        public void swim(){

        }

    }
}
