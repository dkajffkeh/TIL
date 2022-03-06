package me.patrick.laboratory.referencebook.oopprinciple.javapattern.factorymethod;

public class FactoryMethodPattern {

    public static abstract class Animal{
        abstract AnimalToy getToy();
    }

    public static abstract class AnimalToy{
        abstract void identify();
    }

    public static class DogToy extends AnimalToy{
        @Override
        void identify() {

        }
    }

    public static class CatToy extends AnimalToy{
        @Override
        void identify() {

        }
    }

    public static class Cat extends Animal{

        @Override
        AnimalToy getToy() {
            return new CatToy();
        }
    }

    public static class Dog extends Animal{

        @Override
        AnimalToy getToy() {
            return new DogToy();
        }
    }
}
